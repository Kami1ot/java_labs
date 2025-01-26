// 35. Создайте класс ColorModel для определения цветовой модели. Разработайте подклассы RGBconverter и CMYKconverter для конвертации цвета из одной модели в другую.
// Конвертация CMYK в RGB производится по следующим формулам: R = 255 × (1-C) × (1-K), G = 255 × (1-M) × (1-K), B = 255 × (1-Y) × (1-K)
// (где R – red, G – green, B – black, C – Cyan, M - Magenta, Y - Yellow, K- Black))

class ColorModel {
    protected double r, g, b;
    protected double c, m, y, k;

    public ColorModel() {
    }
}

class RGBConverter extends ColorModel {
    public void fromCMYK(double c, double m, double y, double k) {
        this.r = 255 * (1 - c) * (1 - k);
        this.g = 255 * (1 - m) * (1 - k);
        this.b = 255 * (1 - y) * (1 - k);
    }

    public String getRGB() {
        return "RGB(" + (int) r + ", " + (int) g + ", " + (int) b + ")";
    }
}

class CMYKConverter extends ColorModel {
    public void fromRGB(double r, double g, double b) {
        double rNorm = r / 255.0;
        double gNorm = g / 255.0;
        double bNorm = b / 255.0;

        k = 1 - Math.max(rNorm, Math.max(gNorm, bNorm));
        c = (1 - rNorm - k) / (1 - k);
        m = (1 - gNorm - k) / (1 - k);
        y = (1 - bNorm - k) / (1 - k);

        if (Double.isNaN(c)) c = 0;
        if (Double.isNaN(m)) m = 0;
        if (Double.isNaN(y)) y = 0;
    }

    public String getCMYK() {
        return String.format("CMYK(%.2f, %.2f, %.2f, %.2f)", c, m, y, k);
    }
}

public class P_Main_35 {
    public static void main(String[] args) {
        RGBConverter rgbConverter = new RGBConverter();
        rgbConverter.fromCMYK(0.1, 0.2, 0.3, 0.4);
        System.out.println("Конвертация CMYK в RGB: " + rgbConverter.getRGB());

        CMYKConverter cmykConverter = new CMYKConverter();
        cmykConverter.fromRGB(128, 64, 32);
        System.out.println("Конвертация RGB в CMYK: " + cmykConverter.getCMYK());
    }
}
