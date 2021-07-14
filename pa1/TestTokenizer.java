
package cs310;
import java.util.TreeSet;
import java.util.Set;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.FileReader;

public class TestTokenizer {

	public static Set executeTokenizer(JavaTokenizer tokenizer){

		TreeSet<String> set = new TreeSet<String>();
		JavaTokenizer tok;

		tok = tokenizer;
		
    	String token;
    	while ((token = tok.getNextID())!= ""){
    		set.add(token);
    	}
    	return set;

    }

	public static void main(String[ ] args) {	

        FileReader x = null;
        FileReader y = null;	
        try 
        {
        	x = new FileReader("BankAccount.java");
            Set<String> w = executeTokenizer(new WTokenizer(x));
			//System.out.println(w);
			Set<String> temp = new TreeSet<String>(w);

			y = new FileReader("BankAccount.java");
			Set<String> r = executeTokenizer(new RegexTokenizer(y));
			//System.out.println(r);
			Set<String> temp2 = new TreeSet<String>(r);

			r.removeAll(temp);
			w.removeAll(temp2);

			if(r.isEmpty() && w.isEmpty()){
				System.out.println("Both tokenizers report the same results");
			}
			else {
				System.out.println("Both tokenizers do not report the same results");
				System.out.println("in WTokenizer but not Regex:" + (w));
				System.out.println("in Regex but not Wtokenizer:" + (r));
			}

            x.close( );
        }
        catch( IOException e )
        {
            System.err.println( e + args[ 0 ] );
        }
        finally
        {
            try
            {
                if( x != null )
                    x.close( );
            }
            catch( IOException e )
            {
            }
        }            
    }

}
