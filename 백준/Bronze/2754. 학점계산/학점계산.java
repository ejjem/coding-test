import java.util.*;
import java.io.*;

class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char c = str.charAt(0);
        char c2;
        switch(c) {
        case 'A':
        	c2 = str.charAt(1); 
        	switch(c2) {
        	case '+':
        		System.out.println(4.3);
        		break;
        	case '0':
        		System.out.println(4.0);
        		break;
        	case '-':
        		System.out.println(3.7);
        		break;
        	}
        	break;
        case 'B':
        	c2 = str.charAt(1);
        	switch(c2) {
        	case '+':
        		System.out.println(3.3);
        		break;
        	case '0':
        		System.out.println(3.0);
        		break;
        	case '-':
        		System.out.println(2.7);
        		break;
        	}
        	break;
        	
        case 'C':
        	c2 = str.charAt(1);
        	switch(c2) {
        	case '+':
        		System.out.println(2.3);
        		break;
        	case '0':
        		System.out.println(2.0);
        		break;
        	case '-':
        		System.out.println(1.7);
        		break;
        	}
        	break;
        case 'D':
        	c2 = str.charAt(1);
        	switch(c2) {
        	case '+':
        		System.out.println(1.3);
        		break;
        	case '0':
        		System.out.println(1.0);
        		break;
        	case '-':
        		System.out.println(0.7);
        		break;
        	}
        	break;
        case 'F':
        	System.out.println(0.0);
        	break;
        }
    }
}