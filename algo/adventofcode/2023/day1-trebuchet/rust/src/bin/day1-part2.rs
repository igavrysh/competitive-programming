use std::io;
use std::fs::File;
use std::io::{BufRead, Write};

const WORDS_DIGITS:[&str; 10] = [
    "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
];

fn parse_line(line: &str) -> u32 {
    let mut digits: Vec<u32> = vec![];

    for i in 0..line.len() {
        if line.chars().nth(i).is_some_and(|c| c.is_ascii_digit()) {
            digits.push(line.chars().nth(i).unwrap_or('0').to_digit(10).unwrap());
        }

        for (w, val) in WORDS_DIGITS.iter().enumerate() {
            if line[i..].starts_with(val) {
                digits.push(w as u32);
            }
        }
    }

    if digits.len() == 0 {
        panic!("not enough digits")
    }

    digits.first().unwrap() * 10 + digits.last().unwrap()
}

fn print_code() -> io::Result<()> {
    let file = File::open("day1-part2-input").unwrap();

    let reader = io::BufReader::new(file);

    let nums: Vec<u32> = reader.lines().map(|x| x.unwrap()).map(|l| parse_line(&l)).collect();

    write_to_file(&nums, "day1-part2-output-printcode")?;


    println!("{}", nums.iter().sum::<u32>());

    Ok(())
}

fn write_to_file(nums: &Vec<u32>, file_path: &str) -> io::Result<()> {
    let mut file = File::create(file_path)?;

    for num in nums.iter() {
        let line = format!("{}", num);
        writeln!(file, "{}", line)?;
    }

    file.flush()?;

    Ok(())
}

fn main() -> io::Result<()> {
    print_code()
}