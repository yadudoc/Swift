type file;


file inputA <"061-cattwo.1.in">;
file inputB <"061-cattwo.2.in">;

file output <"061-cattwo.out">;

(file t) cat(file m, file n) { 
    app {
        cat @filename(m) @filename(n) stdout=@filename(t);
    }
}

output = cat(inputA, inputB);

