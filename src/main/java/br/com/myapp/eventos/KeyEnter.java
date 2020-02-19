// 
// Decompiled by Procyon v0.5.36
// 

package br.com.myapp.eventos;

import java.awt.Robot;

public class KeyEnter implements Polimorfo
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
        robot.keyPress(10);
        robot.keyRelease(10);
    }
    
    @Override
    public String toString() {
        return "Enter";
    }
}
