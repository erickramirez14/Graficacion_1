package AnimarObjeto;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Circulo {
    
    //coordenadas
    private int coordenadasx, coordendasy;
    
    //tamaño
    private int radio;
    
    //instancia del color
    private Color color;
    
    //sentido en que se mueve
    private int sentido;
    
    //sentidos posibles
    private final int arriba=1;
    private final int arribaderecha=2;
    private final int derecha=3;
    private final int derechaabajo=4;
    private final int abajo=5;
    private final int izquierdaabajo=6;
    private final int izquierda=7;
    private final int izquierdaarriba=8;

    //velocidad
    private int velocidad;
    
    //margenes de la ventana
    private int minx, miny, maxx, maxy;
    
    //objeto de tipo random
    private Random random;
    
    public Circulo(int ancho, int alto, int radio, int velocidad){
        //definir objeto random
        random= new Random();
        
        //definir color
        color= new Color(
                random.nextInt(255),
                random.nextInt(255),
                random.nextInt(255));
        
        //definir coordenadas iniciales
        this.coordenadasx= this.random.nextInt(ancho - radio);
        this.coordendasy= this.random.nextInt(alto - radio);
        
                //definir el radio
                this.radio= radio;
                
                //definir sentido
                this.sentido = 1+ random.nextInt(8);
                
                //definir velocidad
                this.velocidad= velocidad;
                
                //definir coordenadas minimas
                this.minx=0;
                this.miny=0;
                
                //definir coordenadas maximas
                this.maxx=ancho;
                this.maxy=alto;
                 
    }
    public void dibujar(Graphics graphics){
     
        graphics.setColor(this.color);
        graphics.fillOval(this.coordenadasx, 
                            this.coordendasy, 
                            this.radio, 
                            this.radio);
        }
     
public void animar(){
    //siguientes coordenadas positivas
    int xpositiva =this.coordenadasx + this.velocidad;
    int ypositiva =this.coordendasy+ this.velocidad;
    
    //siguientes coordenadas negativas
    int xnegativas = this.coordenadasx - this.velocidad;
    int ynegativas = this.coordendasy - this.velocidad;
    
    //logica para determinar colisiones y sentido
    switch (this.sentido) {
        case arriba:
            if (ynegativas > this.miny) {
                this.coordendasy = ynegativas;
            }else{
                int sentido = 1+random.nextInt(3);
                switch (sentido){
                    case 1: this.sentido= abajo;break;
                    case 2: this.sentido=izquierdaabajo;break;        
                    case 3: this.sentido=derechaabajo;break;
                }
                        
                }
            
            break;
            case arribaderecha:
                if ((ynegativas> this.miny) && (xpositiva<this.maxx)) {
                    //aplicar incremento o decremento
                    this.coordenadasx= xpositiva;
                    this.coordendasy= ynegativas;
                    
                }else{
                     int sentido = 1+random.nextInt(3);
                switch (sentido){
                    case 1: this.sentido= abajo;break;
                    case 2: this.sentido=izquierdaabajo;break;        
                    case 3: this.sentido=izquierda;break;
                }
                }
            
            break;
            case derecha:
                 if (xpositiva<this.maxx) {
                    //aplicar incremento o decremento
                    this.coordenadasx= xpositiva;
                    
                    
                }else{
                      int sentido = 1+random.nextInt(3);
                switch (sentido){
                    case 1: this.sentido= izquierda;break;
                    case 2: this.sentido=izquierdaabajo;break;        
                    case 3: this.sentido=izquierdaarriba;break;
                }
                 }
            
            break;
            case derechaabajo:
                 if ((ypositiva< this.maxy) && (xpositiva<this.maxx)) {
                    //aplicar incremento o decremento
                    this.coordenadasx= xpositiva;
                    this.coordendasy= ypositiva;
                    
                }else{ int sentido = 1+random.nextInt(3);
                switch (sentido){
                    case 1: this.sentido= izquierda;break;
                    case 2: this.sentido= izquierdaarriba;break;        
                    case 3: this.sentido=arriba;break;
                }
                 }
            
            
            break;
            case abajo:
             if ((ypositiva< this.maxy) ) {
                    //aplicar incremento o decremento
                  
                    this.coordendasy= ypositiva;
                    
             }else{ int sentido = 1+random.nextInt(3);
                switch (sentido){
                    case 1: this.sentido= izquierdaarriba;break;
                    case 2: this.sentido= arribaderecha;break;        
                    case 3: this.sentido=arriba;break;
                }
                 }
            break;
            case izquierdaabajo:
                 if ((ypositiva< this.maxy) && (xnegativas>this.minx)) {
                    //aplicar incremento o decremento
                    this.coordenadasx= xnegativas;
                    this.coordendasy= ypositiva;
                    
                }else{ int sentido = 1+random.nextInt(3);
                switch (sentido){
                    case 1: this.sentido= derecha;break;
                    case 2: this.sentido= arribaderecha;break;        
                    case 3: this.sentido=arriba;break;
                }
                 }
          
            
            break;
            case izquierda:
                if ((xnegativas>this.minx)) {
                    this.coordenadasx= xnegativas;
                    
                    
                }else{ int sentido = 1+random.nextInt(3);
                switch (sentido){
                    case 1: this.sentido= izquierda;break;
                    case 2: this.sentido= izquierdaarriba;break;        
                    case 3: this.sentido=izquierdaabajo;break;
                }
                 }
            
            
            break;
            case izquierdaarriba:
                       if ((ynegativas< this.miny) &&(xnegativas>this.minx)) {
                    this.coordenadasx= xnegativas;
                    this.coordendasy=ynegativas;
                    
                    
                }else{ int sentido = 1+random.nextInt(3);
                switch (sentido){
                    case 1: this.sentido= derecha;break;
                    case 2: this.sentido= abajo;break;        
                    case 3: this.sentido=derechaabajo;break;
                }
                 }   
            
            
            break;
        default:
            throw new AssertionError();
    }
    
}

}