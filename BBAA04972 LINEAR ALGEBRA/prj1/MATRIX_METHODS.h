//functions for convenience
double** allocateMemory(int m, int n);
void releaseMemory(double** A, int m);
void printMatrix(double** A, int m, int n, char name[]);
double** constructIdentity(int k);

//functions to implement in prj0 
double** transposeMatrix(double** A, int m, int n);
double** normalizeVector(double** v, int n);

double** multiplyTwoMatrices(double** A, int m, int n, double** B, int l, int k);
double** normaliseMatrix(double** v, int m, int n);
double** addTwoMatrices(double** A, int m, int n, double** B, int l, int k);

int doubleEquals(double a, double b);

//functions for convenience
double** allocateMemory(int m, int n) {
	double** A;
	A = (double**)malloc(sizeof(double*) * m);
	for (int i = 0; i < m; i++) {
		A[i] = (double*)malloc(sizeof(double) * n);
	}
	return A;
}


void releaseMemory(double** A, int m) {
	for (int i = 0; i < m; i++)
		free(A[i]);
	free(A);
}

void printMatrix(double** A, int m, int n, char name[]) {
	printf("\n%s = \n", name);
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++)
			printf("%lf ", A[i][j]);
		printf("\n");
	}
}

//functions to implement in prj0 
double** transposeMatrix(double** A, int m, int n) {
	double** B = allocateMemory(n, m);

	for (int i = 0; i < m; i++) {
		//printf("\n%d\n", i);
		for (int j = 0; j < n; j++) {
			//printf("%d, ", j);

			B[j][i] = A[i][j];
		}
	}

	return B;
}

double** normalizeVector(double** v, int m) {
	double** w;
	double len = 0.0;

	for (int i = 0; i < m; i++)
		len += v[i][0] * v[i][0];
	len = sqrt(len);

	w = allocateMemory(m, 1);
	for (int i = 0; i < m; i++)
		w[i][0] = v[i][0] / len;

	return w;
}

double** normaliseMatrix(double** v, int m, int n) {
	double** w = allocateMemory(m, n);
	for (int i = 0; i < m; i++) {
		double len = 0;
		for (int j = 0; j < n; j++) {
			len += v[j][i] * v[j][i];
		}
		len = sqrt(len);
		for (int j = 0; j < n; j++) {
			w[j][i] = v[j][i] / len;
		}
	}

	return w;
}

double** constructIdentity(int k) {
	double** I = allocateMemory(k, k);

	for (int i = 0; i < k; i++) {
		for (int j = 0; j < k; j++) {
			if (i != j)
				I[i][j] = 0.0;
			else
				I[i][j] = 1.0;
		}
	}
	return I;
}

double** multiplyTwoMatrices(double** A, int m, int n, double** B, int p, int q) {
	if (n != p) return NULL;

	double** AB = allocateMemory(m, q);

	for (int i = 0; i < m; i++) {
		for (int j = 0; j < q; j++) {
			AB[i][j] = 0;
			for (int k = 0; k < p; k++) {
				AB[i][j] += A[i][k] * B[k][j];
			}
		}
	}

	return AB;
}

double** addTwoMatrices(double** A, int m, int n, double** B, int l, int k) {
	if (m != l || n != k) return NULL;

	double** C = allocateMemory(m, n);
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			C[i][j] = A[i][j] + B[i][j];
		}
	}

	return C;
}

const double EPSILON = 0.001;
int doubleEquals(double a, double b) {
	return abs(a - b) < EPSILON;
}