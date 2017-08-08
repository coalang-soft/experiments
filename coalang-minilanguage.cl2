//do - syntax
#snippet do\s+([a-zA-Z0-9_@]+)\s+(.*)\s+and\s+store\s+in\s+([a-zA-Z0-9_@]+) var %3$s = %1$s(%2$s);
#snippet do\s+([a-zA-Z0-9_@]+)\s+(.+) %1$s(%2$s);
#snippet do\s+([a-zA-Z0-9_@]+) %1$s();

//action - syntax
#block action\s+([a-zA-Z0-9_@]+) (.*) def %1$s(%2$s){%3$s}
#snippet action\s+([a-zA-Z0-9]+)\s+does\s+(.+) def %1$s(){%2$s;}
#snippet action\s+([a-zA-Z0-9]+)\s+returns\s+(.+) def %1$s(){return %2$s;}

//loop - syntax
#snippet loop\s+(.+)\s+times\s+(.*) for(1,integer(%1$s)){%2$s;}
#snippet loop\s+forever\s+(.*) while(true){%1$s;}
#snippet loop\s+from\s+(.+)\s+to\s+(.+)\s+and\s+(.*) for(integer(%1$s),integer(%2$s)){%3$s;}
#block loop\s+forever (.*) while(true){%2$s}
#block loop\s+(.+)\s+times (.*) for(1,integer(%1$s)){%3$s}
#block loop\s+from(.+)\s+to\s+(.+) (.*) for(integer(%1$s),integer(%2$s)){%4$s}

//when - syntax
#snippet when\s+(.+)\s+then\s+(.*) if(%1$s){%2$s;}
#block when\s+(.+) (.*) if(%1$s){%3$s}

//operators
#alias times mul
#alias plus add
#alias minus sub

//first and second parameter for functions and blocks
#alias x @.0
#alias y @.1

//standard api
action say does java("javax.swing.JOptionPane").showMessageDialog(undefined,x);
action ask returns java("javax.swing.JOptionPane").showInputDialog(undefined,x);
action crash does throw x;
