type file;


file input <"060-duplicate.in">;

file output <"060-duplicate.out">;

(file t) echo(file m) { 
    app {
        echo @filename(m) stdout=@filename(t);
    }
}

output = echo(input);

