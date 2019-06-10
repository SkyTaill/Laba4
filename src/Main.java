import LexAnaliz.Lexer;
import LexAnaliz.Token;
import Parcer.Parser;
import Parcer.Poliz;
import Stack.PolizCalculation;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Lexer lexer = new Lexer();
        LinkedList<Token> tokens = lexer.lex("c = 2; i = 5; a new List; a.add(5+5); a.add(4); a.add(2); b new Set; b.add(3); b.add(3); c = a.get(1); while(i < 5){i = i + 1;} c++; c++;" );
        System.out.println("Token");
        for (int i = 0; i < tokens.size(); i++)
        {
            System.out.println(tokens.get(i));
        }
        try {
            Parser.parse(tokens);
        }catch ( Exception ex)
        { System.err.println(ex);
            System.exit(1);
        }
        System.out.println("OPZ:");
        LinkedList<Token> testPoliz = Poliz.makePoliz(tokens);
        int i = 0;
        for (Token token : testPoliz) {
            System.out.println(i + " " + token);
            i++;
        }
        System.out.println("Таблица переменных:");
        PolizCalculation.calculate(testPoliz);

    }
}
