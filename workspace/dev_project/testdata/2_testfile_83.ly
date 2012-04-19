\version "2.12.0" 

ignore = \override NoteColumn #'ignore-collision = ##t
\book {
	\score {
		<<
		\new Staff {
			<<
			\new Voice {
				{ 
					% instrument: Piano
					% measures: 23
					% difficulty: 83
					
					\ignore
					\clef treble
					\time 8/8
					\key b \major
					\tempo 4 = 120 
					
% Section ----------

% Phrase:
e''4 b'4 b'4 gis'4 gis'4 e'4 b8 cis'32 b32 dis'32 e'32 cis'4 fis'4 fis'4 b'4 b'4 
% Phrase:
e''4 b'4 b'8 cis''8 gis'4 r8 ais'8 e'4 b32 ais32 cis'32 b32 ais8 cis'4 fis'4 fis'4 b'4 b'4 
% Phrase:
fis''4 cis''8 cis''8 ais'16 gis'16 r8 fis'16 gis'16 fis'16 e'16 dis'4 dis'4 b4 e'4 gis'4 dis''4 dis''4 cis''8 b'8 
% Phrase:
b4 cis'4 cis''4 cis''4 fis''4 <dis'' fis'' ais''>8 <dis'' fis'' ais''>8 dis'4 dis'4 

% Section ----------

% Phrase:
b4 e'4 b'16 cis''16 cis''8 cis''4 ais'4 cis''4 e''4 gis'4 b'4 gis'8 gis'8 e'8 e'8 cis'4 
% Phrase:
b4 e'4 b'8 ais'16 gis'16 cis''8 b'16 ais'16 ais'4 <cis'' e'' gis''>4 e''4 gis'4 b'4 gis'4 e'8 fis'8 cis'4 
% Phrase:
b4 dis'4 fis'8 gis'16 gis'16 <ais' cis'' e''>8 b'8 e''4 <gis'' b'' dis'''>4 b''4 fis''4 dis''4 b'8 ais'8 dis'8 dis'8 e'4 
% Phrase:
b16 ais16 ais8 <gis' b' dis''>4 e''4 gis''4 b''8 ais''8 ais''4 cis'8 dis'16 e'16 cis'4 

% Section ----------

% Phrase:
b4 b'4 e''8 fis''8 cis'16 cis'16 b8 

				}
			}
			>>
		}
		\new Staff {
			\new Voice {
				{ 
					\clef bass
					\time 8/8
					\key b \major 
					\tempo 4 = 120 
					
% Section ----------

% Phrase:
<e gis b>4 <b, dis fis>4 <b, dis fis>4 <gis, b, dis>4 <gis, b, dis>4 <e, gis, b,>4 <b,, dis, fis,>4 <cis, e, gis,>4 <fis, ais, cis>4 <fis, ais, cis>4 <b, dis fis>4 <b, dis fis>4 
% Phrase:
<e gis b>4 <b, dis fis>4 <b, dis fis>4 <gis, b, dis>4 <gis, b, dis>4 <e, gis, b,>4 <b,, dis, fis,>4 <cis, e, gis,>4 <fis, ais, cis>4 <fis, ais, cis>4 <b, dis fis>4 <b, dis fis>4 
% Phrase:
<fis ais cis'>4 <cis e gis>4 <ais, cis e>4 <fis, ais, cis>4 <dis, fis, ais,>4 <dis, fis, ais,>4 <b,, dis, fis,>4 <e, gis, b,>4 <gis, b, dis>4 <dis fis ais>4 <dis fis ais>4 <cis e gis>4 
% Phrase:
<b,, dis, fis,>4 <cis, e, gis,>4 <ais, cis e>4 <cis e gis>4 <fis ais cis'>4 <dis fis ais>4 <dis, fis, ais,>4 <dis, fis, ais,>4 

% Section ----------

% Phrase:
<b,, dis, fis,>4 <e, gis, b,>4 <b, dis fis>4 <cis e gis>4 <ais, cis e>4 <cis e gis>4 <e gis b>4 <gis, b, dis>4 <b, dis fis>4 <gis, b, dis>4 <e, gis, b,>4 <cis, e, gis,>4 
% Phrase:
<b,, dis, fis,>4 <e, gis, b,>4 <b, dis fis>4 <cis e gis>4 <ais, cis e>4 <cis e gis>4 <e gis b>4 <gis, b, dis>4 <b, dis fis>4 <gis, b, dis>4 <e, gis, b,>4 <cis, e, gis,>4 
% Phrase:
<b,, dis, fis,>4 <dis, fis, ais,>4 <fis, ais, cis>4 <ais, cis e>4 <e gis b>4 <gis b dis'>4 <b dis' fis'>4 <fis ais cis'>4 <dis fis ais>4 <b, dis fis>4 <dis, fis, ais,>4 <e, gis, b,>4 
% Phrase:
<b,, dis, fis,>4 <gis, b, dis>4 <e gis b>4 <gis b dis'>4 <b dis' fis'>4 <ais cis' e'>4 <cis, e, gis,>4 <cis, e, gis,>4 

% Section ----------

% Phrase:
<b,, dis, fis,>4 <b, dis fis>4 <e gis b>4 <cis, e, gis,>4 

				}
			}
		}
		>>

		\midi { }
		\layout { }
	}
}
