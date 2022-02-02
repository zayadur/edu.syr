#   Zayadur Khan    02/21/18    CIS-341     Assignment 1

.data
    string:         .space 1024
    reverse:        .space 1024
    prompt:         .asciiz "Enter your string: "
    original:       .asciiz "Your string was: \n"
    reversed:       .asciiz "The reversed string is: "

.text

    main:

        # prompt user for a string
        li $v0, 4                   
        la $a0, prompt
        syscall

        li $v0, 8                   # read string
        la $a0, string              # store string
        li $a1, 1024
        syscall

        # store length of string
        la $t0, string              # address
        li $t2, 0                   # length

        forLoop:
            lb $t1, ($t0)
            beq $t1, 0, end_forLoop   
            add $t2, $t2, 1             # increment length
            add $t0, $t0, 1             # next string location
            b forLoop
        end_forLoop:

        # reverse the string
        li $t0, 0

        reverseLoop:
            blt $t2, 1, end_reverseLoop     # if less than 1, exit loop
            sub $t2, $t2, 1                 # decrement by 1
            lb $t1, string($t2)             
            sb $t1, reverse($t0)
            add $t0, $t0, 1                 # reverse indices
            b reverseLoop
        end_reverseLoop:
        
        li $t1, 0
        sb $t1, reverse($t0)

        # display results
        li $v0, 4
        la $a0, original            # original prompt
        syscall

        li $v0, 4
        la $a0, string              # original string
        syscall

        # print reversed string
        li $v0, 4
        la $a0, reversed            # reversed prompt
        syscall

        li $v0, 4
        la $a0, reverse             # print reversed string
        syscall

        # exit program
        li $v0, 10
        syscall