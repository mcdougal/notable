\version "2.12.0" 

ignore = \override NoteColumn #'ignore-collision = ##t
\book {
	\score {
		<<
		\new Staff {
			<<
			\new Voice {
				{ 
					% instrument: Concert Flute
					% measures: 52
					% difficulty: 11
					
					\ignore
					\clef treble
					\time 4/4
					\key fis \major
					\tempo 4 = 120 
					
% Section ----------

% Phrase:
fis''2 b''2 b''2 ais''2 cis'''2 gis''2 fis'''2 dis'''2 b''2 b''2 gis''2 ais''2 
% Phrase:
fis'''2 f'''2 cis'''2 b''2 b''2 f'''2 fis''2 ais''2 dis'''2 b''2 b''2 dis'''2 
% Phrase:
fis'''2 fis''2 

% Section ----------

% Phrase:
fis''2 gis''2 cis'''2 gis''2 b''2 dis'''2 fis'''2 f'''2 b''2 gis''2 gis''2 ais''2 
% Phrase:
fis''2 gis''2 cis'''2 ais''2 cis'''2 ais''2 fis'''2 f'''2 dis'''2 cis'''2 ais''2 cis'''2 
% Phrase:
fis'''2 fis''2 

% Section ----------

% Phrase:
fis''2 b''2 b''2 ais''2 cis'''2 gis''2 fis'''2 dis'''2 b''2 b''2 gis''2 ais''2 
% Phrase:
fis'''2 f'''2 cis'''2 b''2 b''2 f'''2 fis''2 ais''2 dis'''2 b''2 b''2 dis'''2 
% Phrase:
fis'''2 fis''2 

% Section ----------

% Phrase:
fis'''2 dis'''2 dis'''2 b''2 dis'''2 b''2 fis''2 gis''2 b''2 dis'''2 ais''2 cis'''2 
% Phrase:
fis''2 cis'''2 cis'''2 gis''2 b''2 dis'''2 fis'''2 cis'''2 gis''2 gis''2 cis'''2 ais''2 
% Phrase:
fis''2 fis'''2 

				}
			}
			>>
		}
		>>

		\midi { }
		\layout { }
	}
}
