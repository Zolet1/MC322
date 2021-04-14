package mc322.lab03;

public class AquarioLombriga {
	public int Taq;
    public int Tlomb;
    public int p; //p-> posição da cabeça da lombriga;
    public int L; //L-> lado: 1: cabeça para a esquerda. 2:Cabeça para a direita;
    
    public AquarioLombriga( int Taq, int Tlomb, int p){
        this.Taq = Taq;
        this.Tlomb = Tlomb;
        this.p = p + (this.Tlomb) ;
        this.L = 2;
        if( Tlomb > Taq){
            Taq=Tlomb;
        }
        if ( L== 1 && p+(Tlomb-1)>Taq){
            p = 1;
        }
        if ( L== 2 && p<Tlomb){
            p=Taq;
        }
    }
    public void crescer(){
        if(this.Tlomb < this.Taq){
            if(this.L==1 && this.p + this.Tlomb <= this.Taq){
                this.Tlomb++;
            }
            else{
                if(( this.Taq - this.p ) + this.Tlomb <= this.Taq){
                this.Tlomb++;
                }
            }
        }
    }
    public void mover(){
        if(this.Tlomb < this.Taq){
            if(this.L==1 && this.p > 1){
                    this.p--;
            }
            else{
                if(p<this.Taq){
                    this.p++;
                }
            }
        }
    }
    public void virar(){
        if(this.L==1){
            this.p = this.p + (this.Tlomb - 1);
            this.L = 2;
        }
        else{
            this.p = this.p + 1 - this.Tlomb;
            this.L = 1;
        }
    }
    public void apresenta(){
        String vet[] = new String[this.Taq];
        if(this.L==1){
            for(int i=1; i<=this.Taq; i++){
                if(i == this.p){
                    vet[i-1] = "O";
                }
                else if( i>this.p && i<=(this.Tlomb + p - 1) ){
                    vet[i-1] = "@";   
                }
                else{
                    vet[i-1] = "#";
                }
            }
        }
        else{
            for(int i=1; i<=this.Taq; i++){
                if ( i>= (this.p - this.Tlomb + 1) && i < this.p){
                    vet[i-1]= "@";
                }
                else if (i== this.p){
                    vet[i-1]= "O";
                }
                else{
                    vet[i-1]= "#";
                }
            }
        }
        for (int j=0;j<this.Taq;j++){
            System.out.print(vet[j]);
        }
        System.out.println("");
        
    }
}
