\version "2.12.0" 

ignore = \override NoteColumn #'ignore-collision = ##t
\book {
	\score {
		<<
		\new Staff {
			<<
			\new Voice {
				{ 
					% instrument: Alto Recorder
					% measures: 46
					% difficulty: 43
					
					\ignore
					\clef treble
					\time 5/4
					\key fis \major
					\tempo 4 = 120 
					
% Section ----------

% Phrase:
fis'4 cis'4 dis'8 cis'8 cis'4 b4 ais4 dis'4 gis8 fis8 fis4 ais4 gis4 ais4 dis'8 f'8 cis'4 fis'4 
% Phrase:
fis'4 f'4 cis'4 dis'8 cis'8 cis'4 b4 cis'4 gis4 fis8 gis8 ais4 gis4 ais4 dis'4 cis'8 b8 fis'4 
% Phrase:
fis'4 cis'4 dis'8 cis'8 cis'4 b4 ais4 dis'4 gis8 ais8 fis4 ais4 gis4 ais4 dis'8 cis'8 cis'4 fis'4 
% Phrase:
fis'4 cis'8 dis'8 b8 ais8 cis'4 gis4 fis4 b4 cis'4 dis'4 fis'4 

% Section ----------

% Phrase:
fis4 b4 ais4 b8 cis'8 cis'4 dis'4 gis4 f'4 fis'4 b4 cis'4 b4 ais4 gis8 fis8 fis4 
% Phrase:
fis4 fis4 b4 ais4 b4 cis'4 dis'4 f'4 fis'4 cis'4 dis'4 cis'4 b4 ais4 fis4 
% Phrase:
fis4 b4 ais4 b8 b8 cis'4 dis'4 gis4 f'4 fis'8 gis'8 b4 cis'4 b4 ais4 gis8 ais8 fis4 
% Phrase:
fis8 f8 b4 cis'4 dis'4 f'4 fis'4 cis'4 b4 ais4 fis4 

% Section ----------

% Phrase:
fis4 cis'8 b8 b4 cis'4 dis'4 gis4 cis'4 f'4 fis'4 cis'4 dis'4 cis'8 b8 b4 ais4 fis4 
% Phrase:
fis'4 f'4 dis'4 cis'8 dis'8 b4 ais4 f'4 gis4 fis4 b4 ais4 b4 cis'4 dis'8 cis'8 fis'4 
% Phrase:
fis'4 f'4 dis'4 cis'4 b8 cis'8 ais4 f'4 gis4 fis4 b4 ais4 b4 cis'4 dis'4 fis'4 
% Phrase:
fis'8 f'8 cis'4 b4 ais4 gis4 fis4 b4 cis'4 dis'4 fis'4 

% Section ----------

% Phrase:
fis'4 dis'4 f'4 f'4 dis'4 cis'4 b4 gis4 fis4 ais4 gis4 ais4 dis'4 cis'4 fis'4 
% Phrase:
fis4 ais4 gis4 dis'8 cis'8 cis'4 dis'4 cis'4 f'4 fis'4 b4 cis'4 b4 ais4 gis8 ais8 fis4 
% Phrase:
fis'4 dis'4 f'8 dis'8 cis'8 dis'8 b4 ais4 f'4 gis8 fis8 fis8 gis8 b4 ais4 b4 cis'8 b8 dis'8 f'8 fis'4 
% Phrase:
fis'4 cis'4 b4 ais4 gis8 ais8 fis4 b4 cis'4 dis'4 fis'4 

% Section ----------

% Phrase:
fis4 b4 cis'4 dis'8 cis'8 f'4 fis'4 cis'4 b4 ais4 fis4 

				}
			}
			>>
		}
		>>

		\midi { }
		\layout { }
	}
}
