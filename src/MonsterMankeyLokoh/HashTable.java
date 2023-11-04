package MonsterMankeyLokoh;

import java.util.Random;

public class HashTable {
    private Bucket[] table;
    private Hash hasher;
    private int[] keysToSearch = new int[5];
    private int collisions = 0;
    public HashTable(int hashType, int size) {
        this.table = new Bucket[size];
        this.hasher = new Hash(hashType, size);
    }

    public void Add(int key, int value) {
        int index = this.hasher.hashIt(key);
        if(isOccupied(index)) {
            this.table[index].Add(key, value);
            this.collisions++;
        }
        else {
            this.table[index] = new Bucket();
            this.table[index].Add(key, value);
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
        int acc = 0;
        for(int x = 0; x < size; x++) {
            int key = (rand.nextInt(900000000) + 100000000);
            this.Add(key, rand.nextInt());

            if(acc < 5) {
                this.keysToSearch[acc] = key;
                acc++;
            }
        }
    }

    // Tests if a cell of the table is already occupied
    public boolean isOccupied(int index) {
        return !(this.table[index] == null);
    }

    public int[] getKeysToSearch() {
        return keysToSearch;
    }

    public int getCollisions() {
        return collisions;
    }
}