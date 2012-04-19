%{
\header{
  title = ""
  subtitle = ""




            
%}

\version "2.12.0"

\book {
    \score {
        \new Score { c2 d4 }
        \midi { }
    }
}

\book {
\relative c'
{
    \time 3/4
    \clef treble
    \key d \major
    \tempo 4 = 120
    
	c2 d4
            <e g>2 <f a>4
            b2 c4
}
}