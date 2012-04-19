\version "2.12.0" 

ignore = \override NoteColumn #'ignore-collision = ##t
\book {
	\score {
		<<
		\new Staff {
			<<
			\new Voice {
				{ 
					% instrument: Bassoon
					% measures: 96
					% difficulty: 51
					
					\ignore
					\clef bass
					\time 3/4
					\key c \major
					\tempo 4 = 120 
					
% Section ----------

% Phrase:
c4 g8 g8 f4 e4 d4 c'4 d'4 c'8 d'8 f'4 g'4 e'4 f'4 c'4 d'8 c'8 e4 d4 f4 c4 
% Phrase:
g'8 a'8 f'4 b4 c'4 b4 a4 g4 f4 d4 c8 b,8 d4 g4 f4 g4 c'4 d'4 e'4 g'4 
% Phrase:
c4 d8 e8 r4 f4 g4 r4 b4 e'8 f'8 r4 g'4 f'4 r4 d'4 c'8 d'8 r4 f4 e4 r4 
% Phrase:
g'8 a'8 r4 c8 b,8 

% Section ----------

% Phrase:
g'8 f'8 c'4 d'4 e'8 f'8 d'4 a4 g8 f8 f4 d4 c8 b,8 d4 g4 f8 e8 g4 c'4 d'8 e'8 e'4 g'4 
% Phrase:
g'4 c'8 b8 d'8 c'8 e'4 d'8 d'8 a8 g8 g4 f8 g8 d8 c8 c4 d8 c8 g8 f8 f4 g8 a8 c'8 b8 d'4 e'8 d'8 g'8 f'8 
% Phrase:
g'4 f'4 d'8 c'8 e'4 b4 a4 g4 f4 d8 e8 c4 d4 f4 e4 d4 c'8 d'8 d'4 e'4 g'4 
% Phrase:
c8 b,8 f'4 g'8 f'8 

% Section ----------

% Phrase:
g'4 f'4 f'8 e'8 c'4 e4 f8 g8 e4 a4 d8 d8 c4 e4 f8 a8 f4 e4 d'8 d'8 e'4 f'4 g'8 f'8 
% Phrase:
c8 c8 g4 f4 e4 f4 b4 c'8 b8 d'4 f'4 g'4 c'4 d'4 c'8 b8 b4 f4 e4 d4 c4 
% Phrase:
c4 g8 f8 f4 e4 f4 b4 c'4 d'8 e'8 f'4 g'4 c'4 d'4 c'4 b8 a8 f4 e4 d4 c4 
% Phrase:
c4 f'8 f'8 g'4 

% Section ----------

% Phrase:
g'8 a'8 d'4 e'4 d'4 c'4 g4 f4 e4 d4 c8 b,8 e4 d4 g4 f4 b4 e'4 d'4 g'4 
% Phrase:
g'8 g'8 d'4 e'4 d'8 c'8 c'4 g4 f8 g8 e4 d4 c8 d8 e4 d4 g8 f8 f4 b4 e'8 d'8 d'4 g'4 
% Phrase:
g'4 d'4 e'8 d'8 d'4 c'4 g4 f4 e4 d8 e8 c4 e4 d4 g4 f4 b8 a8 e'4 d'4 g'4 
% Phrase:
g'4 d4 c8 d8 

% Section ----------

% Phrase:
g'4 c'4 d'4 e'4 d'4 a4 g4 f4 d4 c4 d4 g4 f4 g4 c'4 d'4 e'4 g'4 
% Phrase:
g'4 c'8 b8 d'4 e'4 d'8 d'8 a4 g4 f8 e8 d4 c4 d8 e8 g4 f4 g8 f8 c'4 d'4 e'8 f'8 g'4 
% Phrase:
g'4 f'8 g'8 d'4 e'4 b8 a8 a4 g4 f8 e8 d4 c4 d8 c8 f4 e4 d8 e8 c'4 d'4 e'8 f'8 g'4 
% Phrase:
c4 f'4 g'8 f'8 

% Section ----------

% Phrase:
c4 f'4 g'8 g'8 

				}
			}
			>>
		}
		>>

		\midi { }
		\layout { }
	}
}
