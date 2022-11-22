double** constructHaarMatrixRecursive(int n);
double** concatenateTwoMatrices(double** hl, double** hr, int n);
double** applyKroneckerProduct(double** A, int n, double a, double b);


double** constructHaarMatrixRecursive(int n) {
	double** h;
	if (n > 2)
		h = constructHaarMatrixRecursive(n / 2);
	else {
		//double** h;
		h = allocateMemory(2, 2);
		h[0][0] = 1; h[0][1] = 1; h[1][0] = 1; h[1][1] = -1; //H = [1 1; 1 -1]
		return h;
	}

	// construct left part (Kronecket product of h and [1;1]
	double** Hl = applyKroneckerProduct(h, n, 1, 1);
	releaseMemory(h, n / 2);

	// construct right part (Kronecker product of I and [1;-1]
	double** I = constructIdentity(n / 2);
	double** Hr = applyKroneckerProduct(I, n, 1, -1);
	releaseMemory(I, n / 2);


	// merge hl and hr
	double** H = concatenateTwoMatrices(Hl, Hr, n); //H = [hl hr]
	releaseMemory(Hl, n);
	releaseMemory(Hr, n);

	return H;
}

double** applyKroneckerProduct(double** A, int n, double a, double b) {
	double** h = allocateMemory(n, n / 2);

	for (int j = 0; j < n / 2; j++) {
		for (int i = 0; i < n / 2; i++) {
			h[2 * i][j] = A[i][j] * a;
			h[2 * i + 1][j] = A[i][j] * b;
		}
	}
	return h;
}

double** concatenateTwoMatrices(double** hl, double** hr, int n) {
	double** H = allocateMemory(n, n);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (j < n / 2)
				H[i][j] = hl[i][j];
			else
				H[i][j] = hr[i][j - n / 2];
		}
	}
	return H;
}
