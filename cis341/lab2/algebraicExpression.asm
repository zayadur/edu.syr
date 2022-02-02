# C

i = N * N + 3 * N == N * (N + 3)

# MIPS unoptimized (before ==)

lw      $t0, 4($gp)     # fetch N
mult    $t0, $t0, $t0   # N * N
lw      $t1, 4($gp)     # fetch N
ori     $t2, $zero, 3   # 3
mult    $t1, $t1, $t2   # 3 * N
add		$t2, $t1, $t1	# N * N + 3 * N
sw      $t2, 0($gp)     # i

# MIPS optimized (after ==)

lw      $t0, 4($gp)         # $t0 = n | fetch N
add     $t1, $t0, $zero     # $t1 = n + 0
addi	$t1, $t1, 3			# $t1 = n + 3
mult    $t1, $t1, $t0       # $t1 = (n+3) * n
sw      $t1, 0($gp)         # i
