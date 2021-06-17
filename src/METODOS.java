/*  -----------EQUIPO AGP------------
    INTEGRANTES:
    JOSÉ GIOVANNI CARRILLO RUBIO
    OCHOA MEZA PAÚL ALEJANDRO
    MEDINA SOTO CARLOS ALAN
*/
public class METODOS {

    int temporal;

    public METODOS() {
        this.temporal = temporal;
    }

    public void Burbuja(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[i] > arreglo[j]) {
                    intercambiar(arreglo, i, j);
                }
            }
        }
    }

    public String Bubble(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[i] > arreglo[j]) {
                    intercambiar(arreglo, i, j);
                }
            }
        }
        //System.out.print("Arreglo Ordenado con Burbuja \n");
        //mostrar(arreglo);
        return imprimir(arreglo);

    }

    public void mostrar(int[] arreglo) {
        String cad = "";
        for (int i = 0; i < arreglo.length; i++) {
            cad += "[" + arreglo[i] + "]";
        }
        System.out.print(cad + "\n");
    }

    public String imprimir(int[] arreglo) {
        String cad = "";
        for (int i = 0; i < arreglo.length; i++) {
            cad += "[" + arreglo[i] + "] ";
        }
        return cad;
    }
    
    //FUNCIONA BIEN

    public String Radix(int[] arreglo) {
        int x, i, j;
        for (x = Integer.SIZE - 1; x >= 0; x--) {
            int auxiliar[] = new int[arreglo.length];
            j = 0;
            for (i = 0; i < arreglo.length; i++) {
                boolean mover = arreglo[i] << x >= 0;
                if (x == 0 ? !mover : mover) {
                    auxiliar[j] = arreglo[i];
                    j++;
                } else {
                    arreglo[i - j] = arreglo[i];
                }
            }
            for (i = j; i < auxiliar.length; i++) {
                auxiliar[i] = arreglo[i - j];
            }
            arreglo = auxiliar;
        }
        //System.out.print("El arreglo Ordenado Con Radix es: \n");
        //mostrar(arreglo);
        return imprimir(arreglo);

    }

    //METODO SHELL
   
    public String Shellsort(int[] arreglo) {
        int n = arreglo.length, aux;
        boolean cambios;
        for (int salto = n / 2; salto > 0; salto = salto / 2) {
            cambios = true;
            while (cambios) {
                cambios = false;
                for (int i = 0; i < n - salto; i++) {
                    if (arreglo[i] > arreglo[i + salto]) {
                        aux = arreglo[i];
                        arreglo[i] = arreglo[i + salto];
                        arreglo[i + salto] = aux;
                        cambios = true;
                    }//if
                }//for Comparacion
            }//while de cambios

        }//for dell salto
        //System.out.print("SHELL \n");
        //mostrar(arreglo);
        return imprimir(arreglo);
    }

    //Metodo Quicksort
    public String Quicksort(int[] arreglo, int primero, int ultimo) {
        int i, j, pivote, aux;
        i = primero;
        j = ultimo;
        pivote = arreglo[(primero + ultimo) / 2];
        do {
            while (arreglo[i] < pivote) {
                i++;
            }
            while (arreglo[j] > pivote) {
                j--;
            }
            if (i <= j) {
                intercambiar(arreglo, i, j);
                i++;
                j--;
            }
        } while (i <= j);
        if (primero < j) {
            Quicksort(arreglo, primero, j);
        }
        if (i < ultimo) {
            Quicksort(arreglo, i, ultimo);
        }
        return imprimir(arreglo);

    }

    public String intercalacion(int[] a, int[] b) {
        int i = 0, j, k = 0;
        int c[] = new int[a.length + b.length];
        for (i = j = k; i < a.length && j < b.length; k++) {
            if (a[i] < b[j]) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = b[j];
                j++;
            }
        }
//sobrantes
        for (; i < a.length; i++, k++) {
            c[k] = a[i];
        }

        for (; j < b.length; j++, k++) {
            c[k] = b[j];
        }

        return imprimir(c);
    }

    public int[] mezclaDirecta(int[] arreglo) {
        int i, j, k;
        if (arreglo.length > 1) {

            int ElemIzq = arreglo.length / 2;
            int ElemDer = arreglo.length - ElemIzq;
            int arregloIzq[] = new int[ElemIzq];
            int arregloDer[] = new int[ElemDer];
            //Copiando los elementos de la 1ra parte al arreglo izq
            for (i = 0; i < ElemIzq; i++) {
                arregloIzq[i] = arreglo[i];
            }
            //Copiando los elementos de la 1ra parte al arreglo der
            for (i = ElemIzq; i < ElemIzq + ElemDer; i++) {
                arregloDer[i - ElemIzq] = arreglo[i];
            }
            //Recursividad
            arregloIzq = mezclaDirecta(arregloIzq);
            arregloDer = mezclaDirecta(arregloDer);
            i = j = k = 0;
            while (arregloIzq.length != j && arregloDer.length != k) {
                if (arregloIzq[j] < arregloDer[k]) {
                    arreglo[i] = arregloIzq[j];
                    i++;
                    j++;
                } else {
                    arreglo[i] = arregloDer[k];
                    i++;
                    k++;
                }
            }
            //Arreglo Final
            while (arregloIzq.length != j) {
                arreglo[i] = arregloIzq[j];
                i++;
                j++;
            }

            while (arregloDer.length != k) {
                arreglo[i] = arregloDer[k];
                i++;
                k++;
            }
        }
        return arreglo;
    }
    public void mezclaDirecta2(int[] arreglo) {
        int i, j, k;
        if (arreglo.length > 1) {

            int ElemIzq = arreglo.length / 2;
            int ElemDer = arreglo.length - ElemIzq;
            int arregloIzq[] = new int[ElemIzq];
            int arregloDer[] = new int[ElemDer];
            //Copiando los elementos de la 1ra parte al arreglo izq
            for (i = 0; i < ElemIzq; i++) {
                arregloIzq[i] = arreglo[i];
            }
            //Copiando los elementos de la 1ra parte al arreglo der
            for (i = ElemIzq; i < ElemIzq + ElemDer; i++) {
                arregloDer[i - ElemIzq] = arreglo[i];
            }
            //Recursividad
            arregloIzq = mezclaDirecta(arregloIzq);
            arregloDer = mezclaDirecta(arregloDer);
            i = j = k = 0;
            while (arregloIzq.length != j && arregloDer.length != k) {
                if (arregloIzq[j] < arregloDer[k]) {
                    arreglo[i] = arregloIzq[j];
                    i++;
                    j++;
                } else {
                    arreglo[i] = arregloDer[k];
                    i++;
                    k++;
                }
            }
            //Arreglo Final
            while (arregloIzq.length != j) {
                arreglo[i] = arregloIzq[j];
                i++;
                j++;
            }

            while (arregloDer.length != k) {
                arreglo[i] = arregloDer[k];
                i++;
                k++;
            }
        }
    }    

    public void mezclaNatural(int[] arreglo) {
        int izquierda =0, izq=0;
        int derecha = arreglo.length - 1, der = derecha;
        boolean ordenado = false;
        do {
            ordenado = true;
            izquierda = 0;
            while (izquierda < derecha) {
                izq = izquierda;
                while (izq < derecha && arreglo[izq] <= arreglo[izq + 1]) {
                    izq++;
                }
                der = izq + 1;
                while (der == derecha - 1 || der < derecha && arreglo[der] < arreglo[der + 1]) {
                    der++;
                }
                if (der <= derecha) {
                    mezclaDirecta2(arreglo);
                    ordenado = false;
                }
                izquierda = izq;
            }
        } while (!ordenado);
    }



    public void intercambiar(int[] arreglo, int i, int j) {
        int aux;
        aux = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = aux;
    }

}
