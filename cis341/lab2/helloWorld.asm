# Hello world program

.data   # Data declaration section

out_string: .asciiz "\nHello, world!\n"

.text   # Text section | Assembly language instructions

main:

    li		$v0, 4		        # $v0 = 4 | syscall code for printing string = 4
    la		$a0, out_string		# load address of string to be printed into $a0
    syscall                     # call the OS to perform operations specified in $v0
    li      $v0, 10             # terminate program
    syscall
