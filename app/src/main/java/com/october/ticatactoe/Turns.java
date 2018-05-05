package com.october.ticatactoe;

/**
 * Created by october on 5/5/18.
 */

public class Turns {
    private boolean a1,a2,a3;
    private boolean b1,b2,b3;
    private boolean c1,c2,c3;

    public void saveTurn(String n)
    {
        switch (n){
            case "0":
                this.a1 = true;
                break;
            case "1":
                this.a2 = true;
                break;
            case "2":
                this.a3 = true;
                break;
            case "3":
                this.b1 = true;
                break;
            case "4":
                this.b2 = true;
                break;
            case "5":
                this.b3 = true;
                break;
            case "6":
                this.c1 = true;
                break;
            case "7":
                this.c2 = true;
                break;
            case "8":
                this.c3 = true;
                break;

        }
    }

    public boolean ifWinCombo()
    {
        if(a1&&a2&&a3)
            return true;
        else if(b1&&b2&&b3)
            return true;
        else if(c1&&c2&&c3)
            return true;
        if(a1&&b1&&c1)
            return true;
        if(a2&&b2&&c2)
            return true;
        if(a3&&b3&&c3)
            return true;
        if(a1&&b2&&c3)
            return true;
        if(a3&&b2&&c1)
            return true;
        return false;
    }

}
