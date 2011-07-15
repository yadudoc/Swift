type messagefile {}

app (messagefile t) greeting(string m[]) {
        echo m[0] stdout=@filename(t);
}

messagefile outfile <"025-array-passing.out">;

string msg[] = [ "one", "two" ];

outfile = greeting(msg);


