// 
// Decompiled by Procyon v0.5.36
// 

package br.com.myapp.eventos;

import java.awt.Robot;

public class KeyDelete implements Polimorfo
{
    @Override
    public void executa() {
        Robot robot = null;
        try {
            robot = new Robot();
        }
        catch (Exception failed) {
            System.err.println("Instância do Robot falhou: " + failed);
        }
        robot.keyPress(127);
        robot.keyRelease(127);
    }
    
    @Override
    public String toString() {
        return "Delete";
    }
}
