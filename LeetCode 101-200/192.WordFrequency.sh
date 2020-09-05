# Read from the file words.txt and output the word frequency list to stdout.
#!/bin/bash
many=$(sed 's/ /\n/g' words.txt)
for word in $(printf "$many" | sort -u)
do
	printf "%s %d\n" $word $(printf "$many" | grep -w $word | wc -l) &
done | sort -nru -k2
