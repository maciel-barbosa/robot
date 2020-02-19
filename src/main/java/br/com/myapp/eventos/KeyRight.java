package br.com.myapp.eventos;

import java.awt.Robot;

public class KeyRight implements Polimorfo
{
    @Override
    public void executa() {
        Robot robot = null;
        try {
            robot = new Robot();
        }
        catch (Exception failed) {
            System.err.println("Inst\u00e2ncia do Robot falhou: " + failed);
        }
        robot.keyPress(39);
        robot.keyRelease(39);
    }
    
    @Override
    public String toString() {
        return "Seta Direita";
    }
}
