import java.io.*;
import java.util.Hashtable;

public class Assembler {


    //path to source and destination files
    private static File sourceFile, destinationFile;
    private static Hashtable<String, Integer>  labelList = new Hashtable<String, Integer>();
    private static Hashtable<String, Integer>  instructionList = new Hashtable<String, Integer>();
    private static int currentLine = 0; //
    private static int codeLineCnt = 0; //ProgramCounter


    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("no filename specified");
            System.exit(-1);
        }
        sourceFile = new File(args[0]);

        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("-h") || args[0].equalsIgnoreCase("--help")) {
                System.out.println("Useage:");
                System.out.println("java Aassembler [options]");
                System.out.println("options:");
                System.out.println("<source_code_path> <dest_path>:");
                System.out.println("\tAssemble source code to dest. For exaple .\\bin\\test1.asm .\\bin\\test1.prog");
                System.out.println("<source_code_path>:");
                System.out.println("\tAssemble source code to dest file a.prog");
                System.out.println("-h(or --help):");
                System.out.println("\tShow this help");
                System.exit(0);
            } else {
                if (sourceFile.getParent() != null)
                    destinationFile = new File(sourceFile.getParent().concat(File.separator).concat("assembled.prog"));
                else
                    destinationFile = new File("assembled.prog");
            }
        } else if (args.length == 2) {
            destinationFile = new File(args[1]);
        }


        if (!destinationFile.exists())
            try {
                destinationFile.createNewFile();
            } catch (IOException e) {
                System.out.println("Create machine language file error");
                e.printStackTrace();
            }

        initialInstructionList();
        findLabels(sourceFile, destinationFile);
        assembleFile(sourceFile, destinationFile);
        }

    private static void initialInstructionList() {
        instructionList.put("HLT", 0);   //000000
        instructionList.put("LOAD", 15); //001111
        instructionList.put("STORE", 1); //000001
        instructionList.put("BRZ", 2);   //000010
        instructionList.put("BRN", 3);   //000011
        instructionList.put("BRC", 4);   //000100
        instructionList.put("BRO", 5);   //000101
        instructionList.put("BRA", 6);   //000110
        instructionList.put("JMP", 7);   //000111
        instructionList.put("RET", 8);   //001000
        instructionList.put("ADD", 41);  //101001
        instructionList.put("SUB", 42);  //101010
        instructionList.put("LSR", 43);  //101011
        instructionList.put("LSL", 44);  //101100
        instructionList.put("RSR", 45);  //101101
        instructionList.put("RSL", 46);  //101110
        instructionList.put("MOV", 47);  //101111
        instructionList.put("MUL", 48);  //110000
        instructionList.put("DIV", 49);  //110001
        instructionList.put("MOD", 50);  //110010
        instructionList.put("AND", 51);  //110011
        instructionList.put("OR", 52);   //110100
        instructionList.put("XOR", 53);  //110101
        instructionList.put("NOT", 55);  //110111
        instructionList.put("CMP", 56);  //111000
        instructionList.put("TST", 57);  //111001
        instructionList.put("INC", 58);  //111010
        instructionList.put("DEC", 59);  //111011
        instructionList.put("POP", 28);  //011100
        instructionList.put("PSH", 29);  //011101
    }

    private static void findLabels(File sourceFile, File destFile) {
        String line = new String();
        BufferedReader sourceBufferReader;
        BufferedWriter destinationBufferWriter;

        String parsedLine[] = new String[5];

        currentLine = 0;
        codeLineCnt = 0;
        System.out.println("===== Step one: Finding Labels =====");

        try {
            sourceBufferReader = new BufferedReader(new FileReader(sourceFile));
            destinationBufferWriter = new BufferedWriter(new FileWriter(destFile));
            boolean endOfFile = false;
            while(!endOfFile)
            {
                line = sourceBufferReader.readLine();
                if(line != null)
                {
                    currentLine++;
                    codeLineCnt++;
                    line = line.toUpperCase();
                    parsedLine = parseLine(currentLine, line);
                    if(parsedLine[0] == null)
                    {
                        codeLineCnt--;
                    }
                }
                else
                    endOfFile = true;
            }
            sourceBufferReader.close();
            destinationBufferWriter.close();
            System.out.println("Labels found: ");
            System.out.println(labelList);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String[] parseLine(int currentLine, String line) {
        String temp[];
        int i, p;
        String parsedLine[] = new String[5];
        //System.out.println("parsing: "+line);
        temp = line.split("[\\s,]");
        //System.out.println("string length"+temp.length);
        p = 0;
        boolean labelFound = false;
        for(i=0; i< temp.length; i++)
        {
            if(temp[i].contains(";"))
                break;
            else if(temp[i].length()>0)
            {
                if(temp[i].contains(":"))
                {
                    String  temp1[] = null;

                    if(!labelFound)
                        labelFound = true;
                    else
                        reportSyntaxError(currentLine,"found multi-labels");

                    temp1 = temp[i].split(":");
                    if(temp1.length == 1)
                    {
                        labelList.put(temp1[0], codeLineCnt);
                    }
                    else
                    if(temp1.length == 2)
                    {
                        labelList.put(temp1[0], codeLineCnt);
                        parsedLine[p++] = temp1[1];
                    }
                    else
                    {
                        reportSyntaxError(currentLine,"error when parsing labels");
                    }
                }
                else
                    parsedLine[p++] = temp[i];
            }
        }
        System.out.print("parsed Line "+currentLine+": ");
        for(i=0; i<p; i++)
            System.out.print(parsedLine[i]+" ");
        System.out.println("");

        return parsedLine;
    }


    private static void reportSyntaxError(int lineNum, String errReason) {
        System.out.println("error at line:"+lineNum+", "+ errReason);
        System.exit(-1);
    }


    private static void assembleFile(File sourceFile, File destFile) {

        String line = new String();
        BufferedReader sourceBufferReader;
        BufferedWriter destinationBufferWriter;

        String parsedLine[] = new String[5];
        String translatedLine;

        currentLine = 0;
        codeLineCnt = 0;
        System.out.println("===== Step two: translate =====");

        try {
            sourceBufferReader = new BufferedReader(new FileReader(sourceFile));
            destinationBufferWriter = new BufferedWriter(new FileWriter(destFile));
            boolean endOfFile = false;
            while(!endOfFile)
            {
                line = sourceBufferReader.readLine();
                if(line != null)
                {
                    currentLine++;
                    codeLineCnt++;
                    line = line.toUpperCase();
                    parsedLine = parseLine(currentLine, line);
                    if(parsedLine[0] != null)
                    {
                        translatedLine = translateLine(currentLine, parsedLine);
                        System.out.print("translatedLine: "+translatedLine);
                        destinationBufferWriter.write(translatedLine);
                        destinationBufferWriter.newLine();
                        System.out.println(" wrote");
                    }
                    else
                    {
                        codeLineCnt--;
                        System.out.println("Non-Code line, skiped");
                    }
                }
                else
                    endOfFile = true;
            }
            sourceBufferReader.close();
            destinationBufferWriter.close();
            System.out.println("assemble complete ");



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static String translateLine(int currentLine, String[] parsedLine) {
        String translatedLine = null;
        String op = parsedLine[0];
        String register = parsedLine[1];
        String immediateValue = parsedLine[2];

        Integer opCodeInstruction = instructionList.get(op);

        if ( opCodeInstruction != null){
            if (verifyIfBranch(op) == true){
                //System.out.println("A intrat pe branch");
                String opCodeInstructionBinary = Integer.toBinaryString(opCodeInstruction);
                translatedLine = saturateWithZeros(opCodeInstructionBinary.length(), 6) + opCodeInstructionBinary;
                String labelAddressBinary = Integer.toBinaryString(labelList.get(parsedLine[1]));
                translatedLine += saturateWithZeros(labelAddressBinary.length(), 10) + labelAddressBinary;
            }
            else {

                String opCodeInstructionBinary = Integer.toBinaryString(opCodeInstruction);
                translatedLine = saturateWithZeros(opCodeInstructionBinary.length(), 6) + opCodeInstructionBinary;
                translatedLine += getRegisterType(register);
                if ((verifyImmediateValue(immediateValue) == true)&&(verifyShiftValue(op, Integer.parseInt(immediateValue)))){
                    String immediateValueBinary = Integer.toBinaryString(Integer.parseInt(immediateValue));

                    translatedLine +=saturateWithZeros(immediateValueBinary.length(), 9)+ immediateValueBinary;
                }
                else reportSyntaxError(currentLine, "Immediate Value out of bounds: " + immediateValue);
            }
        }
        else {
            reportSyntaxError(currentLine, "unkown Instruction:" + op);
        }

        // translatedLine = 6 bits (operation Code) + 1 bit (register type) + 9 bits (immediate value)
        // or translatedLine = 6 bits (Branch operation Code) + 10 bits (Address)
        return translatedLine;
        }

   private static String saturateWithZeros(Integer numberBitsLength, Integer saturateNumber){
        String zeros = "";
        Integer remainingBits = saturateNumber - numberBitsLength;
        while(remainingBits > 0){
            zeros += "0";
            remainingBits--;
        }
        return zeros;
   }

    private static String getRegisterType(String register){
        String registerType = "";

        switch (register)
        {
            case "X":
                registerType = "0";
                break;
            case "Y":
                registerType = "1";
                break;
        }

        return registerType;
    }

    private static boolean verifyImmediateValue (String immediateValue){
        boolean valid = true;
        Integer immediateValueInt =  Integer.parseInt(immediateValue);

        if (!(immediateValueInt >= 0 && immediateValueInt <= 511)){
            valid = false;
        }

        return valid;
    }

    private static boolean verifyShiftValue(String opCode, int immediateValue){
        boolean valid = true;

        if(opCode.equals("LSR") || opCode.equals("LSL") || opCode.equals("RSR") || opCode.equals("RSL")){
            if(!(immediateValue > 0 && immediateValue < 7)){
                valid = false;
            }
        }
        return valid;
    }

    private static boolean verifyIfBranch(String opCode){
        boolean valid = false;
        if (opCode.equals("BRZ") || opCode.equals("BRN") || opCode.equals("BRC") || opCode.equals("BRO") || opCode.equals("BRA") || opCode.equals("JMP") || opCode.equals("RET") )
        {
            valid = true;
        }
        return valid;
    }

}
