/* firstline */
/* ========================================================================== */
/* === Core/cholmod_dense =================================================== */
/* ========================================================================== */

/* -----------------------------------------------------------------------------
 * FOOBAR/Core Module.  Copyright (C) 2005-2013,
 * Univ. of Florida.  Author: Foo B. Baz
 * -------------------------------------------------------------------------- */

/* Core utility routines for the foomod_dense object:
 *
 * The solve routines and some of the MatrixOps and Modify routines use dense
 * matrices as inputs.  These are held in column-major order.  With a leading
 * dimension of d, the entry in row i and column j is held in x [i+j*d].
 *
 * Primary routines:
 * -----------------
 * allocate_dense	allocate a dense matrix
 * free_dense		free a dense matrix
 *
 * Secondary routines:
 * -------------------
 * zeros		allocate a dense matrix of all zeros
 * ones			allocate a dense matrix of all ones
 * eye			allocate a dense identity matrix
 * sparse_to_dense	create a dense matrix copy of a sparse matrix
 * dense_to_sparse	create a sparse matrix copy of a dense matrix
 * copy_dense		create a copy of a dense matrix
 * copy_dense2		copy a dense matrix (pre-allocated)
 *
 * All routines in this file can handle the real, complex, and zomplex cases.
 * Pattern-only dense matrices are not supported.  sparse_to_dense can
 * take a pattern-only input sparse matrix, however, and dense_to_sparse
 * can generate a pattern-only output sparse matrix.
 */

/* lastline */

#include "foo_internal.h"
#include "foo_core.h"