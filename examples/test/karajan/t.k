
import("sys.k")

element(f, [x]
  x + 2
)

// Already works:
echo(f(2))

g := element([x]
  x + 2
)

// Already works
echo(executeElement(g, 2))