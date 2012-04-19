\version "2.12.0" 

ignore = \override NoteColumn #'ignore-collision = ##t
\book {
	\score {
		<<
		\new Staff {
			<<
			\new Voice {
				{ 
					% instrument: Guitar
					% measures: 35
					% difficulty: 59
					
					\ignore
					\clef treble
					\time 8/8
					\key b \major
					\tempo 4 = 120 
					
% Section ----------

% Phrase:
b'4 dis''4 dis''4 fis''8 e''8 ais''8 b''8 cis'''4 e'''4 b''4 b''4 gis''4 e''8 dis''8 cis''4 
% Phrase:
e'''4 cis'''4 cis'''4 cis'''8 dis'''8 <fis'' ais'' cis'''>4 dis''4 b'4 cis''4 e''4 ais''4 ais''4 cis'''8 b''8 
% Phrase:
b'8 b'8 dis''4 dis''4 <fis'' ais'' cis'''>4 ais''4 cis'''8 dis'''8 e'''4 b''8 cis'''8 b''4 gis''4 e''4 cis''4 
% Phrase:
b'4 e''4 gis''8 ais''8 b''4 e'''4 gis''4 e''4 cis''4 

% Section ----------

% Phrase:
b'4 dis''4 dis''8 e''8 fis''4 ais''8 b''8 <cis''' e''' >4 e'''4 b''8 b''8 b''4 gis''4 e''4 cis''4 
% Phrase:
e'''4 cis'''8 dis'''8 cis'''8 b''8 cis'''4 fis''4 dis''4 b'4 cis''4 e''4 ais''4 ais''4 cis'''4 
% Phrase:
dis''8 ais'8 dis''4 dis''4 fis''4 ais''4 cis'''4 e'''4 b''4 b''4 gis''4 e''4 cis''4 
% Phrase:
b'4 e''4 gis''4 b''8 ais''8 e'''4 gis''8 fis''8 e''4 cis''4 

% Section ----------

% Phrase:
b'4 dis''4 fis''8 <e'' gis'' b''>8 ais''4 cis'''4 cis'''8 cis'''8 e'''4 b''4 gis''4 <gis'' b'' dis'''>4 e''4 cis''4 
% Phrase:
e'''4 cis'''8 dis'''8 dis'''4 b''4 gis''8 fis''8 e''4 b'4 cis''4 e''4 e''4 gis''4 dis'''4 
% Phrase:
b'4 dis''8 cis''8 fis''4 ais''4 cis'''4 cis'''4 e'''4 b''4 gis''4 gis''4 e''4 cis''4 
% Phrase:
e'''4 dis'''4 gis''4 e''8 dis''8 b'4 <cis'' e'' gis''>4 ais''4 cis'''4 

% Section ----------

% Phrase:
b'4 fis''4 ais''4 cis'''4 e'''4 dis'''4 e''8 e''8 cis''4 

				}
			}
			\new Voice {
				{ 
% Section ----------

% Phrase:
b2 dis'2 ais'2 e''2 b'2 e'2 
% Phrase:
e''2 cis''2 fis'2 b2 e'2 ais'2 
% Phrase:
b2 dis'2 ais'2 e''2 b'2 e'2 
% Phrase:
b2 gis'2 e''2 e'2 

% Section ----------

% Phrase:
b2 dis'2 ais'2 e''2 b'2 e'2 
% Phrase:
e''2 cis''2 fis'2 b2 e'2 ais'2 
% Phrase:
b2 dis'2 ais'2 e''2 b'2 e'2 
% Phrase:
b2 gis'2 e''2 e'2 

% Section ----------

% Phrase:
b2 fis'2 cis''2 e''2 gis'2 e'2 
% Phrase:
e''2 dis''2 gis'2 b2 e'2 gis'2 
% Phrase:
b2 fis'2 cis''2 e''2 gis'2 e'2 
% Phrase:
e''2 gis'2 b2 ais'2 

% Section ----------

% Phrase:
b2 ais'2 e''2 e'2 

				}
			}
			>>
		}
		>>

		\midi { }
		\layout { }
	}
}
