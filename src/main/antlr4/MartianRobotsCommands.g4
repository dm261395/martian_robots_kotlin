grammar MartianRobotsCommands;

// Parser
input : gridCoords robotConstructor+ ;

gridCoords : coordinates NEWLINE ;

robotConstructor : coordinates WHITESPACE orientation NEWLINE INSTRUCTIONS NEWLINE;

orientation : ORIENTATION ;

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





