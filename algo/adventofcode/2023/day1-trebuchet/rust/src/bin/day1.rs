use std::fs::File;
use std::io::{self, BufRead};

fn main() -> io::Result<()> {
    // Open the file
    let file = File::open("input")?;

    // Create a buffered reader to efficiently read lines
    let reader = io::BufReader::new(file);

    let mut output: u32 = 0;

    // Iterate over the lines in the file
    for line in reader.lines() {
        // Print each line to the console
        let delta = match line {
            Ok(str) => {
                let mut first: Option<u32> = None;
                let mut last: Option<u32> = None;
                for c in str.chars() {
                    if !c.is_digit(10) {
                        continue;
                    }

                    let v = c.to_digit(10).unwrap();

                    match (first, last) {
                        (None, None) => first = v.into(),
                        (Some(_), _) => last = v.into(),
                        (_, _) => unreachable!("first should be filled first")
                    }
                }
                
                match (first, last) {
                    (Some(f), Some(l)) => 10*f+l,
                    (Some(f), None) => 10*f+f,
                    (_, _) => panic!("line does not have number: {str}"),
                }
            },
            Err(_) => 0,
        };
        output += delta;
    }

    println!("output: {output}");

    Ok(())
}
