/**Descripción: Clase Cesar la cual encripta y desencripta mensajes
  Alumno: Oscar Fernández Durán
  Fecha: 23/03/19
*/
import javax.swing.JOptionPane;
import java.util.Scanner;
public class Cesar2 {
	private int azar=(int)((Math.random()*9999)+1);
        protected char[] original=new char[75];//Arreglo original
        protected char[] encriptar = new char[original.length]; // Arreglo encriptamiento
        protected char[] descifrar = new char[original.length]; // Arreglo desciframiento
        /** Constructor para inicializar los arreglos, original, de encriptamiento y
         * desciframiento */
        public void ICesar2() {
                for(int a=0;a<original.length;a++)
                        original[a]=(char)('0'+a); //creación del arreglo original con ayuda del UNICODE.
                for (int i=0; i<original.length; i++) 
                        encriptar[i] = original[((i + (azar))) % original.length]; // rotar alfabeto 3 lugares
                for (int i=0; i<original.length; i++) 
                        descifrar[encriptar[i]-'0'] = original[i]; // descifrar inverso a encriptar
        }
	public void ICesar2(int control) {
                for(int a=0;a<original.length;a++)
                        original[a]=(char)('0'+a); //creación del arreglo original con ayuda del UNICODE.
                for (int i=0; i<original.length; i++) 
                        encriptar[i] = original[((i + (control))) % original.length]; // rotar alfabeto 3 lugares
                for (int i=0; i<original.length; i++) 
                        descifrar[encriptar[i]-'0'] = original[i]; // descifrar inverso a encriptar
        }
	public int getAzar(){
		return azar;
	}

        /** Método de encriptamiento */
        public String encriptar(String secreto){
                char[] mensj = secreto.toCharArray(); // arreglo mensaje
                for (int i=0; i<mensj.length; i++){    // ciclo de encriptamiento
                        for(int l=0; l<original.length;l++){
                                if(mensj[i]==original[l]){ //verifica que si se puede ralizar el encriptado
                                        mensj[i] = encriptar[mensj[i] - '0']; // usar letra como índice
                                        l=10000;
                                }
                        }
                }
                return new String(mensj);
        }
        /** Método de desciframiento */
        public String descifrar(String secreto) {
                secreto=secreto.replace('{',' '); 
                char[] mensj = secreto.toCharArray();            // arreglo mensaje
                for (int i=0; i<mensj.length; i++){                      // ciclo desciframiento
                        for(int l=0;l<original.length;l++){
                                if(mensj[i]==original[l]){ //verifica que si se puede ralizar el encriptado 
                                        mensj[i] = descifrar[mensj[i] - '0'];    // usar letra como índice
                                        l=10000;
				}
                        }
                }
                return new String(mensj);
        }
        /** Metodo main para probar el cifrador de César */
        public static void main(String[] args) {
                Cesar2 cifrador = new Cesar2(); // Crear un objeto cifrado de César
                Scanner entr=new Scanner(System.in);
                int h=0;
                while(h==0){
                        String men=JOptionPane.showInputDialog("E para generar una nueva contraseña o D para rescatar contraseña");
                        char ch=men.charAt(0);
                        ch=Character.toUpperCase(ch);
                        if(ch=='E'){ //parte de encriptar en el método main 
				cifrador.ICesar2();
                                String secreto =JOptionPane.showInputDialog("Escribe tu contraseña");
                                secreto = cifrador.encriptar(secreto);
                                System.out.println();
                                secreto=secreto.replace(' ','s');
				Character.toUpperCase(secreto.charAt(0));
				int borra= cifrador.getAzar();
				JOptionPane.showMessageDialog(null, "Nueva contraseña: "+secreto+borra);
				JOptionPane.showMessageDialog(null, "Su número de referencia es: "+borra);
				System.out.println("Nueva contraseña: "+ secreto+borra);
				System.out.println("Su número de referencia es: "+borra);
                                h++;
                        }
                        else if(ch=='D'){ //Parte de desencriptar en el método main
				String secreto=JOptionPane.showInputDialog("Ingrese su contraseña: "); 
                                String numR = JOptionPane.showInputDialog("Ingrese su número de referencia: "); 
				int n=Integer.parseInt(numR); 
				cifrador.ICesar2(n);
                                secreto = cifrador.encriptar(secreto);
				Character.toUpperCase(secreto.charAt(0));
				JOptionPane.showMessageDialog(null, "Contraseña original: "+secreto+numR);
				System.out.println("Contraseña original: "+secreto+numR);
                                h++;
                        }
                }
        }
}

				
