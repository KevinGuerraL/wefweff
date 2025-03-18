
class Verificador {

    // Método que verifica si dos rectángulos se sobreponen
    public static boolean seSobreponen(Rectangulo a, Rectangulo b) {
        // Retorna verdadero si NO se cumple alguna de estas condiciones:
        return !(a.getEsquina2().getX() < b.getEsquina1().getX() ||
                a.getEsquina1().getX() > b.getEsquina2().getX() ||
                a.getEsquina2().getY() < b.getEsquina1().getY() ||
                a.getEsquina1().getY() > b.getEsquina2().getY());
    }

    // Método que verifica si dos rectángulos están juntos (tocándose por los
    // bordes)
    public static boolean estanJuntos(Rectangulo a, Rectangulo b) {
        // Retorna verdadero si NO se sobreponen y comparten alguna línea o borde en
        // común
        return !seSobreponen(a, b) && (a.getEsquina2().getX() == b.getEsquina1().getX() ||
                a.getEsquina1().getX() == b.getEsquina2().getX() ||
                a.getEsquina2().getY() == b.getEsquina1().getY() ||
                a.getEsquina1().getY() == b.getEsquina2().getY());
    }

    // Método que calcula el rectángulo que se forma en la zona de superposición
    // entre dos rectángulos
    public static Rectangulo rectanguloSobre(Rectangulo a, Rectangulo b) {
        // Calcula las coordenadas del rectángulo resultante de la intersección
        double x1 = Math.max(a.getEsquina1().getX(), b.getEsquina1().getX());
        double y1 = Math.max(a.getEsquina1().getY(), b.getEsquina1().getY());
        double x2 = Math.min(a.getEsquina2().getX(), b.getEsquina2().getX());
        double y2 = Math.min(a.getEsquina2().getY(), b.getEsquina2().getY());

        // Si las coordenadas son válidas (x1 < x2 y y1 < y2), hay una intersección
        if (x1 < x2 && y1 < y2) {
            return new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));
        } else {
            return null;// Si no hay intersección, retorna null
        }
    }
}