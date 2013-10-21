#!usr/bin/perl



%myhash=();
open FH1,"C:/Users/Visvanathan/Desktop/result.txt" or die $!;
open FH2,">C:/Users/Visvanathan/Desktop/dictionary.txt" or die $!;
#print <FH1>;
foreach $line(<FH1>)
{
	
	open FHnew,$line or die $!;
	#print $_;
	
	foreach $newline(<FHnew>)
	{
				
			if($newline=~/(\S+)\($/)
			{
				$_="class";
				#if($newline=~/(class)(\s)(\S+)(\s{1})(.+)/)
				#{
					#print $1,"\n";
					
					foreach $keys(%myhash)
					{
					#	print $keys, " number 222=\n";
						if($keys eq $1)
						{
							$count++;	
						#	print "for" ,$1, " $count= ", $count, "\n";
						}
					}
					$myhash{$1}=$count;
						
					print FH2 $1,": ",$count,"\n";			
				#}
				
			}
	}
}
$printline,$final;
open FH3,"C:/Users/Visvanathan/Desktop/dictionary1.txt" or die $!;
foreach $printline(<FH2>)
{
	print $printline, "\n";
}
