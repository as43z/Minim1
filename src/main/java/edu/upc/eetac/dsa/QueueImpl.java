package edu.upc.eetac.dsa;

public class QueueImpl<T> implements Queue<T>{
    private int ilen, nElements;
    private T[] arData;

    public QueueImpl(int ilen){
        this.ilen = ilen;
        this.arData = (T[]) new Object[this.ilen]; //CAST object into T type
        this.nElements = 0;
    }


    @Override
    public void push(T elem) throws FullQueueException {
        if(!this.isFull()){
            this.arData[this.nElements] = elem;
            this.nElements++;
        } else throw new FullQueueException();
    }

    @Override
    public T pop() throws EmptyQueueException {
        T firstElem;
        if(!this.isEmpty()){
            firstElem = this.arData[0];
            this.shiftToLeft();
        } else throw new EmptyQueueException();
        return firstElem;
    }

    @Override
    public int size() {
        return this.nElements;
    }

    public boolean isFull(){
        if(this.nElements < this.ilen) return false;
        else return true;
    }

    public boolean isEmpty(){
        if(this.nElements == 0) return true;
        else return false;
    }

    public void shiftToLeft(){
        for(int i = 0; i < this.nElements - 1; i++) {
            this.arData[i] = this.arData[i + 1];
        }
        this.nElements--;
        this.arData[this.nElements] = null;
    }

    @Override
    public String toString(){
        String mes = "[";
        for(int i = 0; i < this.ilen; i++){
            mes += this.arData[i] + ",";
        }
        return mes + "]";
    }
}
