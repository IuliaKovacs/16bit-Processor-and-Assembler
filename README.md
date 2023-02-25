# 16bit_Processor_and_Assembler


We created this application as part of the Computer Engineering Fundamentals course from the 3rd year of university.

General description: Application-Specific Instruction Set Processor (ASIP). The specific application of the processor is that of a pocket calculator. 

The computer works as follows: the user chooses the inputs and operations from the calculator interface, and some templates for operations written in assembly are filled in behind. Once the assembly files are generated, each line is translated into a 16-bit word that contains the opcode, the register used and value, or the opcode and address in the case of branch instructions. Further, the binary files are sent to the hardware part where the instructions are executed and the result is taken back.

Architecture: <br>
![image](https://user-images.githubusercontent.com/101547437/221379229-81790331-5290-41ce-9a0d-fc3b4a48defd.png) 

Graphic Interface: <br>
![image](https://user-images.githubusercontent.com/101547437/221379264-ff7b133a-5e1e-4b53-b964-d226bcdd36d3.png) 


Registers: <br>
 ○ 16-bit Accumulator <br>
 ○ 2 16-bit general purpose (GP) registers: X and Y <br>
 ○ 4-bit Flag register: Zero, Negative, Carry, Overflow <br>
 ○ 16-bit stack pointer <br>
 ○ Program Counter <br><br>
Instruction size: 16-bit <br>

Word size: 16-bit 


Tools and Technologies used: <br>
 ○ Digital <br>
 ○ Java

Remark regarding HW Schemes using Digital tool:
 - In order to open HW Schemes ( *.dig files) go to HW_Design/Digital and execute Digital.jar file
