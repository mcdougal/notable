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
					% difficulty: 62
					
					\ignore
					\clef treble
					\time 9/8
					\key gis \major
					\tempo 4 = 120 
					
% Section ----------

% Phrase:
gis'4 c''4 cis''4 cis'''4 g'''8~g'''8 g'''4 dis'''4 dis''8 f''8 c''4 
% Phrase:
gis'''4 g'''4 cis'''4 cis''8 dis''8 ais'8~ais'8 ais'4 cis''8 dis''8 cis'''4 f'''4 
% Phrase:
gis'4 c''4 cis''8 cis''8 cis'''4 g'''8~g'''8 g'''4 dis'''4 dis''4 c''4 
% Phrase:
gis'4 dis''4 c''4 r4 g'''8~g'''8 dis'''4 dis'''4 ais'4 ais'8 gis'8 
% Phrase:
gis'8 g'8 dis''8 f''8 c''4 dis'''8 f'''8 g'''8~g'''8 dis'''4 dis'''4 ais'4 ais'4 
% Phrase:
gis'8 g'8 c''4 cis''8 c''8 cis'''4 g'''8~g'''8 g'''4 dis'''4 dis''4 c''4 
% Phrase:
gis'4 dis'''4 g'''8 f'''8 g'4 gis'8 

% Section ----------

% Phrase:
gis'''4 f'''4 cis'''8 c'''8 cis''4 ais'8~ais'8 dis''4 c''4 c'''4 dis'''4 
% Phrase:
gis'''4 dis'''4 c'''4 dis''8 cis''8 ais'8~ais'8 dis''4 c''4 dis'''4 g'''4 
% Phrase:
gis'4 cis''4 ais'4 f'''4 g'''8~g'''8 g'''4 cis'''4 cis''4 ais'4 
% Phrase:
gis'''4 f'''4 ais''8 gis''8 dis''4 ais'8~ais'8 ais'4 dis''4 dis'''4 g'''4 
% Phrase:
gis'''8 g'''8 dis'''4 c'''4 dis''4 ais'8~ais'8 dis''4 c''4 dis'''4 g'''4 
% Phrase:
gis'''4 f'''4 cis'''8 c'''8 cis''4 ais'8~ais'8 dis''8 f''8 c''4 c'''4 dis'''8 cis'''8 
% Phrase:
gis'8 ais'8 dis'''4 g'''4 g'4 gis'8 

% Section ----------

% Phrase:
gis'4 c''8 ais'8 cis''8 cis''8 cis'''4 g'''8 gis'''8 g'''4 dis'''4 dis''4 c''8 c''8 
% Phrase:
gis'''4 g'''8 gis'''8 cis'''4 cis''4 ais'8 gis'8 ais'8 gis'8 cis''4 cis'''4 f'''8 dis'''8 
% Phrase:
gis'4 c''8 c''8 cis''4 cis'''4 g'''8~g'''8 g'''4 dis'''4 dis''4 c''4 
% Phrase:
gis'4 dis''4 c''4 dis'''8 dis'''8 g'''8~g'''8 dis'''4 dis'''8 f'''8 ais'8 c''8 ais'4 
% Phrase:
gis'4 dis''8 cis''8 c''4 dis'''8 cis'''8 g'''8 f'''8 dis'''4 dis'''4 ais'4 ais'4 
% Phrase:
gis'8 g'8 c''4 cis''4 r4 g'''8~g'''8 g'''4 dis'''8 dis'''8 dis''4 c''4 
% Phrase:
gis'4 dis'''8 cis'''8 g'''4 g'4 gis'8 

% Section ----------

% Phrase:
gis'''4 g'''4 dis'''4 dis''4 ais'8~ais'8 dis''4 c''4 dis'''8 f'''8 g'''8 gis'''8 
% Phrase:
gis'8 ais'8 cis''4 ais'8 c''8 f'''4 g'''8 f'''8 g'''4 dis'''4 dis''4 c''4 
% Phrase:
gis'''4 g'''4 dis'''4 dis''4 ais'8~ais'8 r4 c''4 dis'''4 g'''4 
% Phrase:
gis'4 ais'4 cis''4 cis'''8 cis'''8 g'''8 g'''8 cis'''8 c'''8 cis'''8 c'''8 cis''4 ais'4 
% Phrase:
gis'4 c''4 dis''4 dis'''4 g'''8~g'''8 dis'''4 dis'''8 f'''8 dis''8 cis''8 c''4 
% Phrase:
gis'4 cis''4 ais'8 c''8 f'''4 g'''8~g'''8 g'''8 f'''8 dis'''8 f'''8 dis''4 c''4 
% Phrase:
gis'4 dis'''8 gis'''8 g'''4 g'4 gis'8 

				}
			}
			>>
		}
		>>

		\midi { }
		\layout { }
	}
}
