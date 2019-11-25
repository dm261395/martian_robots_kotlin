grammar MartianRobotsGrammar;

// Parser
input : gridCoords ;

gridCoords : coordinates NEWLINE ;

coordinates : xCoord WHITESPACE yCoord ;

xCoord : NUMBER ;

yCoord : NUMBER ;

// Lexer
WHITESPACE : (' ' | '\t')+ ;

NEWLINE : ('\r'? '\n' | '\r')+ ;

fragment DIGIT : [0-9] ;
NUMBER : DIGIT+ ;

// Orientation
fragment NORTH : 'N' ;
fragment EAST : 'E' ;
fragment SOUTH : 'S' ;
fragment WEST : 'W' ;
ORIENTATION : (NORTH | EAST | SOUTH | WEST) ;

// Instructions
fragment FORWARD : 'F' ;
fragment LEFT : 'L' ;
fragment RIGHT : 'R' ;
fragment INSTRUCTION : (FORWARD | LEFT | RIGHT) ;
INSTRUCTIONS : INSTRUCTION+ ;





