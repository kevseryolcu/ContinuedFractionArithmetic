package com.company;

public class CF_Arithmetic {
    private int a, b, c, d, e, f, g, h;
    private CF x, y;

    public CF_Arithmetic(CF x, CF y)
    {
        this.x = x;
        this.y = y;
    }


    public CF add(CF x, CF y)
    {
        a = 0;
        b = 1;
        c = 1;
        d = 0;
        e = 1;
        f = 0;
        g = 0;
        h = 0;
    }
    public CF sub(CF x, CF y)
    {
        a = 0;
        b = 1;
        c = -1;
        d = 0;
        e = 1;
        f = 0;
        g = 0;
        h = 0;
    }
    public CF mul(CF x, CF y)
    {
        a = 0;
        b = 0;
        c = 0;
        d = 1;
        e = 1;
        f = 0;
        g = 0;
        h = 0;
    }
    public CF div(CF x, CF y)
    {
        a = 0;
        b = 1;
        c = 0;
        d = 0;
        e = 0;
        f = 0;
        g = 1;
        h = 0;
    }
    private CF calculate(CF x, CF y)
    {
        int next;
        while ((next = x.next()) != 0)
        {
            if (checkOutput())
            {
                //output();
            }
        }
    }

    //returns true if input X, false otherwise
    public boolean checkInput()
    {
        if(this.e == 0)
        {
            return false;
        }
        else if (this.f == 0 && this.g == 0)
        {
            return false;
        }
        var left = Math.abs((int)(this.b/this.f) - (int)(this.a / this.e));

        var right = Math.abs((int)(this.c/this.g) - (int)(this.a / this.e));
        if(left > right)
        {
            return true;
        }
        return false;
    }

    public boolean checkOutput()
    {
        if(this.e == 0 || this.f == 0 || this.g == 0 || this.h == 0)
        {
            return false;
        }
        int tmp1 = (int)(a/e);
        int tmp2 = (int)(b/f);
        int tmp3 = (int)(c/g);
        int tmp4 = (int)(d/h);
        if (tmp1 == tmp2 && tmp2 == tmp3 && tmp3 == tmp4)
        {
            return true;
        }
        return false;
    }

    public void inputX(int term)
    {
        int na, nb, nc, nd, ne, nf, ng, nh;
        na = b;
        nb = a + b * term;
        nc = d;
        nd = c + d * term;
        ne = f;
        nf = e + f * term;
        ng = h;
        nh = g + h * term;

        a = na; b = nb; c = nc; d = nd;
        e =  ne; f = nf; g = ng; h = nh;
    }

    public void inputY(int term)
    {
        int na, nb, nc, nd, ne, nf, ng, nh;
        na = c;
        nb = d;
        nc = a + c * term;
        nd = b + d * term;
        ne = g;
        nf = h;
        ng = e + g * term;
        nh = f + h * term;

        a = na; b = nb; c = nc; d = nd;
        e =  ne; f = nf; g = ng; h = nh;
    }

    public void output(int term)
    {
        int na, nb, nc, nd, ne, nf, ng, nh;
        na = e;
        nb = f;
        nc = g;
        nd = h;
        ne = a - e * term;
        nf = b - f * term;
        ng = c - g * term;
        nh = d - h *term;

        a = na; b = nb; c = nc; d = nd;
        e =  ne; f = nf; g = ng; h = nh;
    }
}


