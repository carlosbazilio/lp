
fn main() {
    // let mut s = "hello";
    let mut s = String::from("hello");
    s.push_str(" world!");
    println!("{s}");

    let s2 = s;
    // println!("{}\n", s);
    // Error because "hello" value was moved after line 8

    let s3 = s2.clone();

    println!("s2 = {}, s3 = {}", s2, s3);

    takes_ownership(s2);

    println!("s3 = {}, s3's size = {}", s3, calculate_length(&s3));
}

fn takes_ownership(some_string: String) { // some_string comes into scope
    println!("{}", some_string);
} // Here, some_string goes out of scope and `drop` is called. The backing
  // memory is freed.

fn makes_copy(some_integer: i32) { // some_integer comes into scope
    println!("{}", some_integer);
}

fn calculate_length(s: &String) -> usize { // s is a reference to a String
    s.len()
} // Here, s goes out of scope. But because it does not have ownership of what
  // it refers to, it is not dropped.
