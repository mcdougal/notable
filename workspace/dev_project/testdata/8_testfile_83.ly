\version "2.12.0" 

ignore = \override NoteColumn #'ignore-collision = ##t
\book {
	\score {
		<<
		\new Staff {
			<<
			\new Voice {
				{ 
					% instrument: Cello
					% measures: 72
					% difficulty: 83
					
					\ignore
					\clef bass
					\time 8/8
					\key b \major
					\tempo 4 = 120 
					
% Section ----------

% Phrase:
b,8 ais,8 e4 e4 gis8 ais8 e'8 dis'8 gis'8 fis'8 b'8 b'8 fis'4 b4 b8 cis'16 b16 e4 cis4 
% Phrase:
b'4 fis'4 fis'4 e'32 fis'32 fis'32 gis'32 b'8 e16 fis16 fis8 e4 b,4 e4 gis4 e8 dis8 e'4 gis'8 ais'8 
% Phrase:
b,4 e8 dis8 ais4 ais4 gis'16 fis'16 gis'8 fis'4 b'16 b'16 ais'8 ais'4 fis'4 fis'4 dis4 dis4 
% Phrase:
b'8 b'8 fis'4 b4 fis4 fis4 fis4 b,4 cis4 fis4 ais4 e'4 gis'4 
% Phrase:
b'4 ais'4 gis4 e4 b,4 fis8 e8 dis'4 r8 gis'8 

% Section ----------

% Phrase:
b,16 cis16 b,8 e4 e4 fis8 gis8 e'4 gis'4 b'4 fis'4 e'4 cis'4 fis4 dis4 
% Phrase:
b,4 dis4 fis8 e16 fis16 fis8 gis8 fis'4 fis'8 gis'8 b'4 gis'4 dis'4 fis'4 fis8 fis16 gis16 dis4 
% Phrase:
b,8 cis8 e4 e4 fis4 e'4 gis'4 b'8 ais'8 fis'4 e'4 cis'4 fis4 dis4 
% Phrase:
b,4 cis8 dis8 e8 dis8 dis4 r4 gis'4 b'4 e'4 fis'4 ais4 fis8 fis8 r4 
% Phrase:
b,8 e8 dis8 e8 dis'4 fis'4 b'4 gis'4 fis8 gis16 fis16 dis8 cis8 

% Section ----------

% Phrase:
b'4 fis'4 e'4 e'4 e16 fis16 e8 e4 b,4 fis8 e8 dis4 fis4 fis'4 ais'4 
% Phrase:
b'8 ais'8 fis'8 gis'8 e'8 e'8 e'4 e4 e4 b,16 ais,16 cis8 fis4 dis4 fis4 fis'4 ais'4 
% Phrase:
b'8 b'8 dis'8 dis'8 dis'4 dis'4 fis8 e8 dis4 b,4 e4 gis4 b4 dis'4 fis'4 
% Phrase:
b,4 fis8 gis8 dis8 cis8 dis4 dis'8 cis'8 fis'4 b'4 ais'4 gis'4 b'4 cis4 cis4 
% Phrase:
b'4 ais'8 ais'8 e8 e8 e8 dis8 b,4 e4 e'4 gis'4 

% Section ----------

% Phrase:
b,4 e4 e8 fis8 gis4 e'8 e'8 gis'16 fis'16 fis'8 b'4 fis'4 b4 b4 e4 cis4 
% Phrase:
b'16 ais'16 b'8 fis'4 fis'4 gis'4 e4 e4 b,8 ais,8 e8 dis16 e16 gis4 gis4 e'4 gis'4 
% Phrase:
b,8 b,8 e16 dis16 fis8 ais4 ais4 gis'4 fis'8 gis'8 b'8 b'8 ais'4 fis'8 gis'8 fis'8 gis'8 dis4 dis4 
% Phrase:
b'8 b'8 fis'4 r8 cis'8 fis4 fis4 fis4 b,4 cis4 fis4 ais8 b8 e'8 fis'8 gis'4 
% Phrase:
b'8 b'8 ais'4 b8 fis8 e4 b,4 fis4 dis'8 e'16 e'16 fis'4 

% Section ----------

% Phrase:
b,4 e4 ais4 ais16 ais16 gis8 e'8 fis'8 gis'4 b'4 fis'4 dis'4 ais'8 b'8 dis4 fis4 
% Phrase:
b'4 fis'4 fis'8 e'16 dis'16 fis'4 fis4 fis4 r4 dis4 dis4 fis4 e'8 dis'8 gis'4 
% Phrase:
b'4 fis'8 gis'8 fis'4 fis'16 gis'16 fis'16 fis'16 fis8 gis8 fis4 b,4 dis4 dis8 cis8 fis4 e'8 dis'16 cis'16 gis'4 
% Phrase:
b,8 cis8 e8 fis8 gis8 fis8 b4 dis'8 dis'8 fis'4 b'4 e'4 gis'8 ais'16 ais'16 e'4 cis4 cis4 
% Phrase:
b'4 ais'4 e4 e8 fis8 b,4 dis8 e8 fis'4 ais'8 b'8 

% Section ----------

% Phrase:
b,8 ais,8 cis4 e'4 gis'4 b'4 fis'8 e'16 fis'16 dis4 fis4 

				}
			}
			>>
		}
		>>

		\midi { }
		\layout { }
	}
}
