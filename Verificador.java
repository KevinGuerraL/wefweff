public class Verificador {

    // Método que verifica si dos rectángulos se sobreponen
    public static boolean seSobreponen(Rectangulo a, Rectangulo b) {

        // Retorna verdadero si NO hay un espacio vacío entre los rectángulos
        // Si alguna de estas condiciones es verdadera, significa que NO se sobreponen
        return !(a.getEsquina2().getX() <= b.getEsquina1().getX() ||
                a.getEsquina1().getX() >= b.getEsquina2().getX() ||
                a.getEsquina2().getY() <= b.getEsquina1().getY() ||
                a.getEsquina1().getY() >= b.getEsquina2().getY());
    }

    // Método que verifica si dos rectángulos están juntos (comparten un borde)
    public static boolean estanJuntos(Rectangulo a, Rectangulo b) {

        // Para que estén juntos, no deben sobreponerse
        // Además, deben compartir algún borde (izquierdo, derecho, superior o inferior)
        return !seSobreponen(a, b) && (a.getEsquina2().getX() == b.getEsquina1().getX() ||
                a.getEsquina1().getX() == b.getEsquina2().getX() ||
                a.getEsquina2().getY() == b.getEsquina1().getY() ||
                a.getEsquina1().getY() == b.getEsquina2().getY());
    }

    // Método que calcula el rectángulo que resulta de la intersección
    // (superposición)
    public static Rectangulo rectanguloSobre(Rectangulo a, Rectangulo b) {

        // Se calcula el punto inferior izquierdo de la intersección (x1, y1)
        // Se calcula el punto superior derecho de la intersección (x2, y2)
        double x1 = Math.max(a.getEsquina1().getX(), b.getEsquina1().getX());
        double y1 = Math.max(a.getEsquina1().getY(), b.getEsquina1().getY());
        double x2 = Math.min(a.getEsquina2().getX(), b.getEsquina2().getX());
        double y2 = Math.min(a.getEsquina2().getY(), b.getEsquina2().getY());
        // Si las coordenadas son válidas (x1 < x2 y y1 < y2), se crea un nuevo
        // rectángulo con el área de superposición
        if (x1 < x2 && y1 < y2) {
            return new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));
        } else {
            return null;
        }
    }
}
