#############################################
#   Zayadur Khan    CIS-341     03/26/17    #
#   Project 2 - mergeSort in MIPS           #
#############################################

.data

    array1: .word 56 3 46 47 34 12 1 5 10 8 33 25 29 31 50 43  # test array
    c: .word 0:20   # represents c[]
    return: .asciiz "\nresult: "    # return prompt
    comma: .asciiz ","  # seperator
    

.text

main:
    move $a0, $s2
    move $a1, $zero
    addi $s2, $s0, -1
    sw $ra, 0($sp)  # saving return address on stack
    jal mergeSort

p1:
	la $s2, array1
	addi $s0, 10
	j call

call:
    move $a0, $s2
    move $a1, $zero
    addi $a2, $s0, -1
    jal mergeSort

end:
    move $t0, $zero
    move $t1, $s2
    la $a0, return
    syscall

# prints result to console
print:
    beq $t0, $s0, kill
    lw $t2, 0($t1)
    move $a0, $t2
    li $v0, 1
    syscall

    la $a0, comma   # seperator

    li $v0, 4
    syscall

    addi $t0, $t0, 1
    addi $t1, $t1, 4
    j print

# terminates program
kill:
    li $v0, 10
    syscall

mergeSort:
    addi $sp, $sp, -20
    sw $ra, 0($sp)
    sw $a0, 4($sp)
    sw $a1, 8($sp)
    sw $a2, 12($sp)
    slt $t0, $a1, $a2   # if(low >= high)
    beq $t0, $zero, mergeSortEnd

    add $t0, $a1, $a2   # mid
    srl $a3, $t0, 1
    sw $a3, 16($sp)

    lw $a0, 4($sp)  # a[i]
    lw $a1, 8($sp)  # low
    lw $a2, 16($sp) # mid
    jal mergeSort

    lw $a0, 4($sp)  # a[i]
    lw $a1, 16($sp) # mid + 1
    addi $a1, 1
    lw $a2, 12($sp) # high
    jal mergeSort

    lw $a0, 4($sp)  # a[i]
    lw $a1, 8($sp)  # low
    lw $a2, 12($sp) # high
    lw $a3, 16($sp) # mid
    jal merge

mergeSortEnd:
    lw $ra, 0($sp)
    lw $a0, 4($sp)
    lw $a1, 8($sp)
    lw $a2, 12($sp)
    addi $sp, $sp, 20
    jr $ra

merge:
    addi $sp, $sp, -20
    sw $ra, 0($sp)
    sw $a0, 4($sp)  # 
    sw $a1, 8($sp)  # low
    sw $a2, 12($sp) # high
    sw $a3, 16($sp) # mid
    lw $t1, 8($sp)  # i
    lw $t3, 16($sp) # j
    lw $t2, 8($sp)  # k

    addi $t3, $t3, 1
    la $s3, c

thisWhile:
    slt $t0, $a3, $t1   # while(i <= mid && j <= high)
    bne $t0, $zero, thatWhile   # otherwise go to next while
    
    slt $t0, $a2, $t3
    bne $t0, $zero, thatWhile

if:
    sll $t4, $t1, 2 # a[i]
    add $t4, $t4, $a0
    lw $t4, 0($t4)

    sll $t5, $t3, 2 # a[j]
    add $t5, $t5, $a0
    lw $t5, 0($t5)

    slt $t0, $t4, $t5   # if(a[i] < a[j])
    beq $t0, $zero, else

    sll $t6, $t2, 2 # c[k] = a[i]
    add $t6, $t6, $s3
    sw $t4, 0($t6)

    addi $t1, $t1, 1    # i++
    addi $t2, $t2, 1    # k++
    
    j thisWhile # jump to original while
else:
    sll $t6, $t2, 2 # c[k] = a[j]
    add $t6, $t6, $s3
    sw $t5, 0($t6)
    addi $t3, $t3, 1    # j++
    addi $t2, $t2, 1    # k++
    j thisWhile # jump to original while

thatWhile:
    slt $t0, $s3, $t1   # while(i <= mid)
    bne $t0, $zero, otherWhile  # jump to otherWhile
    
    sll $t4, $t1, 2
    add $t4, $t4, $a0
    lw $t4, 0($t4)

    sll $t6, $t2, 2 # c[k] = a[i]
    add $t6, $t6, $s3
    sw $t4, 0($t6)

    addi $t1, $t1, 1    # i++
    addi $t2, $t2, 1    # k++

    j thatWhile # loop back to thatWhile

otherWhile:
    slt $t0, $a2, $t3   # check if j <= high
    bne $t0, $zero, for # if no match, go to for loop

    sll $t5, $t3, 2 # a[j]
    add $t5, $t5, $a0
    lw $t5, 0($t5)

    sll $t6, $t2, 2 # c[k] = a[j]
    add $t6, $t6, $s3
    sw $t5, 0($t6)
    
    addi $t3, $t3, 1    # j++
    addi $t2, $t2, 1    # k++

    j otherWhile    # loop back to otherWhile

for:
    lw $t1, 8($sp)  # load i
loop:
    slt $t0, $t1, $t2    # check if i < k
    beq $t0, $zero, mergeEnd    # if no match, go to mergeEnd
    
    sll $t4, $t1, 2 # i*4
    add $t5, $t4, $s3
    add $t6, $t4, $a0
    lw $t5, 0($t5)  # load c[i]
    sw $t5, 0($t6)  # save a[i] as c[i]

    addi $t1, $t1, 1    # i++

    j loop  # loop back to beginning of for loop

mergeEnd:
    lw $ra, 0($sp)
    lw $a0, 4($sp)
    lw $a1, 8($sp)
    lw $a2, 12($sp)
    lw $a3, 16($sp)
    addi $sp, $sp, 20
    jr $ra