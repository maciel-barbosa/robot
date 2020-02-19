// 
// Decompiled by Procyon v0.5.36
// 

package br.com.myapp.eventos;

import java.awt.Robot;

public class KeyDown implements Polimorfo
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
        robot.keyPress(40);
        robot.keyRelease(40);
    }
    
    @Override
    public String toString() {
        return "Seta Baixo";
    }
}
