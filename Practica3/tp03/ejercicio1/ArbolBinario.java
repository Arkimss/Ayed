package tp03.ejercicio1;
import tp02.ejercicio3.*;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */
	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Preguntar antes de invocar si tieneHijoIzquierdo()
	 * @return
	 */
	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}

	public int contarHojas() {	
		int aux = 0;
		if (this.esHoja()) {
			return 1;
		}
		if (tieneHijoDerecho() != null) {
			aux += this.getHijoDerecho().contarHojas();
		}
		if (tieneHijoIzquierdo() != null) {
			aux += this.getHijoIzquierdo().contarHojas();
		}
		return aux;
	}
	

    public ArbolBinario<T> espejo() {
    	ArbolBinario<T> nodo = new ArbolBinario<T>(getDato());
    	
    	if (tieneHijoIzquierdo()) {
    		nodo.agregarHijoDerecho(getHijoIzquierdo().espejo());
    	}
    	if(tieneHijoDerecho()) {
    		nodo.agregarHijoIzquierdo(getHijoDerecho().espejo());
    	}    	
    	
		return nodo;
	}


	public void entreNiveles(int n, int m){
		ArbolBinario<T> arbol;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		cola.encolar(this);
		cola.encolar(null);
		int nivel = 0;
		while ((!cola.esVacia()) && (nivel <= m)){
			arbol = cola.desencolar();
			if (arbol != null) {
				if (nivel >= n) 
					System.out.println(arbol.getDato());		
				if (arbol.tieneHijoIzquierdo())
					cola.encolar(arbol.getHijoIzquierdo());
				if (arbol.tieneHijoDerecho())
					cola.encolar(arbol.getHijoDerecho());
			} else if(!cola.esVacia()) {
				if(nivel <= m) { //esta bien?
					nivel++;
				    if(nivel > n) {
						System.out.println("");
					}
					cola.encolar(null);
				}
			}
		}
	}

	

}
