type file;

(file output) process (file input) {
      output = input;      
}

file x <"a.txt">;
file y <"b.txt">;

y = process(x);