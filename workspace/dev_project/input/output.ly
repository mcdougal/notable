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
					% measures: 32
					% difficulty: 51
					
					\ignore
					\clef treble
					\time 4/4
					\key fis \minor
					\tempo 4 = 120 
					
% Section ----------

% Phrase:
fis'4 gis'4 d''4 cis''8 d''8 d''4 e''4 a''4 b''4 cis'''4 e'''4 fis'''4 e'''4 d'''4 e'''4 cis'''4 d'''8 e'''8 a'4 b'4 a'4 fis'4 
% Phrase:
fis'''8 gis'''8 d'''4 e'''4 d'''4 cis'''4 b''4 cis''4 b'4 a'8 b'8 gis'4 fis'4 b'4 a'4 b'4 cis''4 d''4 cis'''8 b''8 d'''4 e'''4 fis'''4 

% Section ----------

% Phrase:
fis'''4 b''8 cis'''8 cis'''8 b''8 b''4 a''4 gis''4 d''8 e''8 cis''4 b'4 gis'4 fis'8 e'8 a'4 gis'4 b'8 a'8 a'8 b'8 gis'4 cis'''4 d'''4 e'''8 d'''8 fis'''4 
% Phrase:
fis'''4 d'''4 cis'''4 b''8 b''8 a''4 gis''4 d''4 cis''8 d''8 b'4 gis'4 fis'4 a'8 b'8 gis'4 fis''4 a'4 gis'8 a'8 cis'''4 d'''4 e'''4 fis'''8 fis'''8 

% Section ----------

% Phrase:
fis'''8 e'''8 d'''4 e'''4 b''4 cis'''4 b''4 cis''4 b'4 a'4 gis'4 fis'4 a'4 gis'8 a'8 a'4 e''4 d''4 cis'''4 d'''4 e'''4 fis'''4 
% Phrase:
b'''4 e'''8 fis'''8 fis'''8 gis'''8 e'''4 fis'''4 e'''4 b'8 a'8 cis''4 b'4 gis'8 gis'8 fis'8 gis'8 cis''4 b'4 cis''4 d''8 e''8 e''4 a'''4 gis'''8 a'''8 a'''8 b'''8 b'''4 

% Section ----------

% Phrase:
fis'8 gis'8 gis'''4 fis'''4 a'''4 b'''8 a'''8 a'4 b'4 fis'4 

				}
			}
			>>
		}
		\new Staff {
			\new Voice {
				{ 
					\clef bass
					\time 4/4
					\key fis \minor 
					\tempo 4 = 120 
					
% Section ----------

% Phrase:
<fis, a, cis>2 <d fis a>2 <d fis a>2 <a cis' e'>2 <cis' e' gis'>2 <fis' a' cis''>2 <d' fis' a'>2 <cis' e' gis'>2 <a, cis e>2 <a, cis e>2 
% Phrase:
<fis' a' cis''>2 <e' gis' b'>2 <cis' e' gis'>2 <cis e gis>2 <a, cis e>2 <fis, a, cis>2 <a, cis e>2 <cis e gis>2 <cis' e' gis'>2 <e' gis' b'>2 

% Section ----------

% Phrase:
<fis' a' cis''>2 <cis' e' gis'>2 <a cis' e'>2 <d fis a>2 <b, d fis>2 <fis, a, cis>2 <gis, b, d>2 <a, cis e>2 <cis' e' gis'>2 <e' gis' b'>2 
% Phrase:
<fis' a' cis''>2 <cis' e' gis'>2 <a cis' e'>2 <d fis a>2 <b, d fis>2 <fis, a, cis>2 <gis, b, d>2 <a, cis e>2 <cis' e' gis'>2 <e' gis' b'>2 

% Section ----------

% Phrase:
<fis' a' cis''>2 <e' gis' b'>2 <cis' e' gis'>2 <cis e gis>2 <a, cis e>2 <fis, a, cis>2 <gis, b, d>2 <e gis b>2 <cis' e' gis'>2 <e' gis' b'>2 
% Phrase:
<b' d'' fis''>2 <fis' a' cis''>2 <fis' a' cis''>2 <b, d fis>2 <b, d fis>2 <fis, a, cis>2 <b, d fis>2 <d fis a>2 <a' cis'' e''>2 <a' cis'' e''>2 

% Section ----------

% Phrase:
<fis, a, cis>2 <fis' a' cis''>2 <b' d'' fis''>2 <b, d fis>2 

				}
			}
		}
		>>

		\midi { }
		\layout { }
	}
}
