// 
// Decompiled by Procyon v0.5.36
// 

package br.com.myapp.eventos;

import java.awt.Robot;

public class KeyLeft implements Polimorfo
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
        robot.keyPress(37);
        robot.keyRelease(37);
    }
    
    @Override
    public String toString() {
        return "Seta Esquerda";
    }
}
