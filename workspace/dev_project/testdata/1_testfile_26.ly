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
					% measures: 30
					% difficulty: 26
					
					\ignore
					\clef bass
					\time 4/4
					\key c \major
					\tempo 4 = 120 
					
% Section ----------

% Phrase:
c'4 g4 a4 g4 a4 g4 f4 g4 f4 d4 c4 g4 f4 e4 f4 e4 f4 g4 a4 c'4 
% Phrase:
c4 f4 e4 f4 g4 a4 f4 g4 a4 b4 c'4 b4 g4 a4 g4 f4 e4 d4 e4 c4 

% Section ----------

% Phrase:
c'4 f4 g4 f4 f4 g4 f4 e4 g4 d4 c4 d4 a4 g4 f4 e4 f4 g4 a4 c'4 
% Phrase:
c4 d4 g4 f4 g4 f4 g4 a4 g4 b4 c'4 f4 g4 f4 e4 d4 e4 d4 e4 c4 

% Section ----------

% Phrase:
c'4 g4 a4 g4 a4 g4 f4 g4 f4 d4 c4 g4 f4 e4 f4 e4 f4 g4 a4 c'4 
% Phrase:
c4 f4 e4 f4 g4 a4 f4 g4 a4 b4 c'4 b4 g4 a4 g4 f4 e4 d4 e4 c4 

				}
			}
			>>
		}
		>>

		\midi { }
		\layout { }
	}
}
