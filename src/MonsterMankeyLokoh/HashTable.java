package MonsterMankeyLokoh;

import java.util.Random;

public class HashTable {
    private Bucket[] table;
    private Hash hasher;
    public HashTable(int hashType, int size) {
        this.table = new Bucket[size];
        this.hasher = new Hash(hashType);
    }

    public void Add(int value) {
        int index = this.hasher.hashIt(value);
        if(isOccupied(index)) {
            this.table[index].Add(value);
        }
        else {
            this.table[index] = new Bucket();
            this.table[index].Add(value);
        }
    }

    public Registry Search(int value) {
        int index = this.hasher.hashIt(value);
        if(!this.isOccupied(index)) return null;
        return this.table[index].Search(value);
    }

    public void Remove(int value) {
        // Milena

        int index = this.hasher.hashIt(value);
        // Testar isOccupied, se estiver, continue.
        // Acessar this.table[index] e usar o método "Remove".
    }

    // Populates the hashing table
    public void Populate(long seed, long size) {
        Random rand = new Random(seed);
        for(int x = 0; x < size; x++)
            this.Add(rand.nextInt(900000000) + 100000000);
    }

    // Tests if a cell of the table is already occupied
    public boolean isOccupied(int index) {
        return !(this.table[index] == null);
    }
}