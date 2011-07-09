package br.edu.utfpr.ap.localiza;

public enum Combustivel {

    Etanol,
    Gasolina,
    Diesel,
    GPL,
    GNV,
    Flex;

    @Override
    public String toString() {
        return "Combustível{" + this + "}";
    }
    
}
